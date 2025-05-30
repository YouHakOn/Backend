package net.youhak.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.youhak.shared.entity.BaseEntity;

@Getter
@Entity
@NoArgsConstructor
public class Login extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private String password;

    @Builder
    public Login(Member member, String password) {
        this.member = member;
        this.password = password;
    }
}
