package com.codecool.characterhandlerservice.controller;


import com.codecool.characterhandlerservice.service.CsharpCallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/csharp")
@RestController()
@RequiredArgsConstructor
public class CsharpController {

    private final CsharpCallerService csharpCallerService;

    @GetMapping("")
    public ResponseEntity testConnection() {
        return ResponseEntity.ok(csharpCallerService.connectionTest());
    }
}
