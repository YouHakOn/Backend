package net.youhak.member.service;

import net.youhak.member.dto.request.LoginRequest;
import net.youhak.member.dto.request.RegisterRequest;

public interface AuthService {
    void registerMember(RegisterRequest registerRequest);
    void loginMember(LoginRequest loginRequest);
}
