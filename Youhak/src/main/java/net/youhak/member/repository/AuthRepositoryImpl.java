package net.youhak.member.repository;

import lombok.RequiredArgsConstructor;
import net.youhak.member.entity.Login;
import net.youhak.member.entity.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class AuthRepositoryImpl implements AuthRepository {

    private final MemberJpaRepository memberJpaRepository;
    private final LoginJpaRepository loginJpaRepository;

    @Transactional
    @Override
    public void registerMember(Member member, Login login) {
        memberJpaRepository.save(member);
        loginJpaRepository.save(login);
    }

    @Transactional(readOnly = true)
    @Override
    public Member getMemberByEmail(String email) {
        return memberJpaRepository.findByEmail(email)
                .orElseThrow();
    }
}
