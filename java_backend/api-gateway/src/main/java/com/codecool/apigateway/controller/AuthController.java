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
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final PlayerService playerService;
    public static final String TOKEN = "token";
    private final DataValidatorService validator;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentials user, HttpServletResponse response, HttpServletRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()
        ));
        String jwtToken = jwtTokenUtil.generateToken(authentication);
        addTokenToCookie(response, jwtToken);
        return ResponseEntity.ok().body(user.getUsername());
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserCredentials user, HttpServletResponse response) {
        playerService.registerNewPlayerData(user);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()
        ));

        String jwtToken = jwtTokenUtil.generateToken(authentication);
        addTokenToCookie(response, jwtToken);
        return ResponseEntity.status(HttpStatus.CREATED).body(user.getUsername());
    }

    private void addTokenToCookie(HttpServletResponse response, String token) {
        ResponseCookie cookie = ResponseCookie.from("token", token)
                .domain("localhost") // should be parameterized
                .sameSite("Strict")  // CSRF
//                .secure(true)
                .maxAge(Duration.ofHours(24))
                .httpOnly(true)      // XSS
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
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
//                .secure(true)
                .maxAge(0)
                .httpOnly(true)      // XSS
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }

    @GetMapping("/current-user/{jwtToken}")
    public String getCurrentUsername(@PathVariable String jwtToken) {
        UsernamePasswordAuthenticationToken userToken = jwtTokenUtil
                .validateTokenAndExtractUserSpringToken(jwtToken);
        return userToken == null ? "" : userToken.getName();
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

//@CrossOrigin
//@RestController
//@RequestMapping("/auth")
//@Slf4j
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//
//    private final JwtTokenServices jwtTokenServices;
//
//    private final DataValidatorService dataValidatorService;
//
//    private final PlayerService playerService;
//
//    private final UserDetailsServiceImpl userDetailsService;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public AuthController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices, DataValidatorService dataValidatorService, PlayerService playerService, UserDetailsServiceImpl userDetailsService) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenServices = jwtTokenServices;
//        this.dataValidatorService = dataValidatorService;
//        this.playerService = playerService;
//        this.userDetailsService = userDetailsService;
//        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody UserCredentials userCredentials) {
//        log.info(userCredentials.getPassword());
//        log.info(userCredentials.getUsername());
//        Map<Object, Object> model = new HashMap<>();
//        try {
//            String username = userCredentials.getUsername();
//            String password = userCredentials.getPassword();
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//            List<String> roles = authentication.getAuthorities()
//                    .stream()
//                    .map(GrantedAuthority::getAuthority)
//                    .collect(Collectors.toList());
//
//            String token = jwtTokenServices.toString(username, roles);
//            model.put("correct", true);
//            model.put("username", username);
//            model.put("roles", roles);
//            model.put("token", token);
//            return ResponseEntity.ok(model);
//        } catch (AuthenticationException e) {
//            model.put("correct", false);
//            model.put("msg", "Wrong username/password!");
//            return ResponseEntity.ok(model);
//        }
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody UserCredentials userCredentials) {
//        String username = userCredentials.getUsername();
//        String password = userCredentials.getPassword();
//
//        Map<Object, Object> model = new HashMap<>();
//        List<String> errorList = new ArrayList<>();
//
//        if (playerService.findByUsername(username) != null){
//            model.put("correct", false);
//            model.put("msg", "Username already exists! Please choose a different username!");
//            return ResponseEntity.ok(model);
//        }
//
//        if(!dataValidatorService.isValidUsername(username, errorList)) {
//            String error = String.join(" , ", errorList);
//            String errorMessage = "Username should have " + error + "!";
//            model.put("correct", false);
//            model.put("msg", errorMessage);
//            return ResponseEntity.ok(model);
//        }
//
//        if (!dataValidatorService.isValidPassword(password, errorList)) {
//            String error = String.join(" , ", errorList);
//            String errorMessage = "Password should contain " + error + "!";
//            model.put("correct", false);
//            model.put("msg", errorMessage);
//            return ResponseEntity.ok(model);
//        }
//
//        UserCredentials newUserCredentials = UserCredentials.builder()
//                .username(username)
//                .password(passwordEncoder.encode(password))
//                .build();
//        playerService.registerNewPlayer(newUserCredentials);
//
//        List<String> roles = Collections.singletonList("ROLE_USER");
//        String token = jwtTokenServices.createToken(username, roles);
//        model.put("correct", true);
//        model.put("username", username);
//        model.put("roles", roles);
//        model.put("token", token);
//        return ResponseEntity.ok(model);
//    }
//
//}
