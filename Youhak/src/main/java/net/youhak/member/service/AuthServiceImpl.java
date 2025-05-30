package net.youhak.member.service;

import net.youhak.member.entity.Login;
import net.youhak.member.entity.Member;
import net.youhak.member.dto.request.LoginRequest;
import net.youhak.member.dto.request.RegisterRequest;
import net.youhak.member.entity.vo.Gender;
import net.youhak.member.repository.AuthRepository;
import net.youhak.member.util.PasswordUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final PasswordUtil passwordUtil;

    public AuthServiceImpl(AuthRepository authRepository, PasswordUtil passwordUtil) {
        this.authRepository = authRepository;
        this.passwordUtil = passwordUtil;
    }

    @Override
    public void registerMember(RegisterRequest registerRequest) {
        String hashedPassword = passwordUtil.hashPassword(registerRequest.password());

        Member member = Member.builder()
                .email(registerRequest.email())
                .nickname(registerRequest.nickname())
                .gender(Gender.getGender(registerRequest.gender()))
                .name(registerRequest.name())
                .build();

        Login login = Login.builder()
                .member(member)
                .password(hashedPassword)
                .build();

        authRepository.registerMember(member, login);
    }

    @Override
    public void loginMember(LoginRequest loginRequest) {
        Member member = authRepository.getMemberByEmail(loginRequest.email());

        boolean passwordMatches = passwordUtil.verifyPassword(loginRequest.password(), member.getLogin().getPassword());

        if (!passwordMatches) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
