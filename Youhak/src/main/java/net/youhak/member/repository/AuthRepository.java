package net.youhak.member.repository;

import net.youhak.member.entity.Login;
import net.youhak.member.entity.Member;


public interface AuthRepository {

    void registerMember(Member member, Login login);

    Member getMemberByEmail(String email);
}
