package net.youhak.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import net.youhak.shared.entity.BaseEntity;

@Entity
@RequiredArgsConstructor
public class Role extends BaseEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private RoleCategory roleCategory;

    @Builder
    public Role(String name, RoleCategory roleCategory) {
        this.name = name;
        this.roleCategory = roleCategory;
    }
}
