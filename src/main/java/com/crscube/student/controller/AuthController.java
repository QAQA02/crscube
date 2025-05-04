package com.crscube.student.controller;

import com.crscube.student.global.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final TokenProvider tokenProvider;

    // 이후 회원가입, 로그인 등 기능 추가 가능
    @PostMapping("/token")
    public ResponseEntity<String> getToken() {
        String token = tokenProvider.generateToken();
        return ResponseEntity.ok(token);
    }
}
