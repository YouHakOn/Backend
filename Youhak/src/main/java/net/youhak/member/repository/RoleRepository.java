package net.youhak.member.repository;

import net.youhak.member.entity.Role;
import net.youhak.member.entity.RoleCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository {

    void roleRegister(Role role);

    void roleDelete(Long roleId);

    void roleCategoryRegister(RoleCategory roleCategory);

    void roleCategoryDelete(Long roleCategoryId);

    RoleCategory findByRoleCategoryId(Long roleCategoryId);
}
