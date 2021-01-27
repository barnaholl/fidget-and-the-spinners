package com.codecool.apigateway.controller;

import com.codecool.apigateway.model.Player;
import com.codecool.apigateway.model.UserCredentials;
import com.codecool.apigateway.security.DataValidatorService;
import com.codecool.apigateway.security.JwtTokenUtil;
import com.codecool.apigateway.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final PlayerService playerService;
    public static final String TOKEN = "token";
    private final DataValidatorService validator;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserCredentials player) {
        String username = player.getUsername();
        String password = player.getPassword();
        String email = player.getEmail();
        if (playerService.findByUsername(username) != null) {
            return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).body("Username already exists!");
        }
        if (playerService.findByEmail(email) != null) {
            return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).body("Email already used!");
        }
        playerService.registerNewPlayerData(player);
        return ResponseEntity.ok().body(player.getUsername());
    }

    private void addTokenToCookie(HttpServletResponse response, String token) {
        ResponseCookie cookie = ResponseCookie.from("token", token)
                .domain("localhost") // should be parameterized
                .sameSite("Strict")  // CSRF
                .maxAge(Duration.ofHours(24))
                .httpOnly(true)      // XSS
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentials player, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                player.getUsername(),
                player.getPassword()
        ));
        String jwtToken = jwtTokenUtil.generateToken(authentication);
        addTokenToCookie(response, jwtToken);
        return ResponseEntity.ok().body(player.getUsername());
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        createLogoutCookie(response);
        return ResponseEntity.ok().build();
    }

    private void createLogoutCookie(HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie.from("token", "")
                .domain("localhost") // should be parameterized
                .sameSite("Strict")  // CSRF
                .maxAge(0)
                .httpOnly(true)      // XSS
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }

    @GetMapping("/current-user/{jwtToken}")
    public Player getCurrentUsername(@PathVariable String jwtToken) {
        UsernamePasswordAuthenticationToken userToken = jwtTokenUtil
                .validateTokenAndExtractUserSpringToken(jwtToken);
        if(userToken == null){
            return null;
        }
        else{
            return playerService.findByUsername(userToken.getName());
        }



    }

    @GetMapping("/current-user-object")
    public Player getCurrentUserObject(HttpServletRequest request) {
        Optional<Cookie> jwtToken =
                Arrays.stream(Optional.ofNullable(request.getCookies()).orElse(new Cookie[]{}))
                        .filter(cookie -> cookie.getName().equals(TOKEN))
                        .findFirst();
        if (jwtToken.isPresent()) {
            UsernamePasswordAuthenticationToken userToken = jwtTokenUtil
                    .validateTokenAndExtractUserSpringToken(jwtToken.get().getValue());
            return playerService.findByUsername(userToken.getName());
        }
        return null;
    }

}
