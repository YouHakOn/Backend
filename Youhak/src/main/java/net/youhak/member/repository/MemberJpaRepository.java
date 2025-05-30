package net.youhak.member.repository;

import java.util.Optional;
import net.youhak.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    @Query("""
        select m
        from Member m
        where m.email = :email
            and m.isDeleted = false
    """)
    Optional<Member> findByEmail(@Param("email") String email);
}
