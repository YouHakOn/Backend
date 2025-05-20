package net.youhak.member.role.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import net.youhak.global.BaseEntity;

@Entity
@RequiredArgsConstructor
public class RoleCategory extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "roleCategory")
    private List<Role> roles = new ArrayList<>();

    @Builder
    public RoleCategory(String name) {
        this.name = name;
    }
}
