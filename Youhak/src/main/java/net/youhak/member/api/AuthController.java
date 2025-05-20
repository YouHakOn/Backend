package net.youhak.member.api;

import lombok.RequiredArgsConstructor;
import net.youhak.member.dto.request.LoginRequest;
import net.youhak.member.dto.request.RegisterRequest;
import net.youhak.member.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerMember(@RequestBody RegisterRequest registerRequest) {
        authService.registerMember(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginMember(@RequestBody LoginRequest loginRequest) {
        authService.loginMember(loginRequest);
        return ResponseEntity.ok().build();
    }
}
