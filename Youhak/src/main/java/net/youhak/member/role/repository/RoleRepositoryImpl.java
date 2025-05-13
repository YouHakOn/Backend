package net.youhak.member.role.repository;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import net.youhak.member.role.domain.Role;
import net.youhak.member.role.domain.RoleCategory;

@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

    private final RoleJpaRepository roleJpaRepository;
    private final RoleCategoryJpaRepository roleCategoryJpaRepository;

    @Override
    public void roleRegister(final Role role) {
        roleJpaRepository.save(role);
    }

    @Override
    public void roleDelete(final Long roleId) {
        roleJpaRepository.deleteById(roleId);
    }

    @Override
    public void roleCategoryRegister(final RoleCategory roleCategory) {
        roleCategoryJpaRepository.save(roleCategory);
    }

    @Override
    public void roleCategoryDelete(final Long roleCategoryId) {
        roleCategoryJpaRepository.deleteById(roleCategoryId);
        roleJpaRepository.deleteByRoleCategoryId(roleCategoryId);
    }

    @Override
    public Optional<RoleCategory> findByRoleCategoryId(final Long roleCategoryId) {
        return roleCategoryJpaRepository.findById(roleCategoryId);
    }
}
