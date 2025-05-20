package net.youhak.member.repository;

import net.youhak.member.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginJpaRepository extends JpaRepository<Login, Long> {
}
