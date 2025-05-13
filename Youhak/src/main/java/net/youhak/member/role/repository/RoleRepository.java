package net.youhak.member.role.repository;

import java.util.Optional;
import net.youhak.member.role.domain.Role;
import net.youhak.member.role.domain.RoleCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository {

    void roleRegister(Role role);

    void roleDelete(Long roleId);

    void roleCategoryRegister(RoleCategory roleCategory);

    void roleCategoryDelete(Long roleCategoryId);

    Optional<RoleCategory> findByRoleCategoryId(Long roleCategoryId);
}
