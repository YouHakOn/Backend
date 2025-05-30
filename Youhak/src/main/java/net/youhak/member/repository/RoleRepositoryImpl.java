package net.youhak.member.repository;

import lombok.RequiredArgsConstructor;
import net.youhak.member.entity.Role;
import net.youhak.member.entity.RoleCategory;
import org.springframework.stereotype.Repository;

@Repository
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
        roleJpaRepository.deleteByRoleCategoryId(roleCategoryId);
        roleCategoryJpaRepository.deleteById(roleCategoryId);
    }

    @Override
    public RoleCategory findByRoleCategoryId(final Long roleCategoryId) {
        return roleCategoryJpaRepository.findById(roleCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("카테고리 아이디가 없습니다."));
    }
}
