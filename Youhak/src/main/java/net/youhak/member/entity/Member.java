package net.youhak.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.youhak.member.entity.vo.Gender;
import net.youhak.member.entity.vo.GenderConverter;
import net.youhak.shared.entity.BaseEntity;

@Getter
@Entity
@NoArgsConstructor
public class Member extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @OneToOne(mappedBy = "member")
    private Login login;

    @Builder
    public Member(String name, String nickname, String email, Gender gender) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.gender = gender;
    }
}
