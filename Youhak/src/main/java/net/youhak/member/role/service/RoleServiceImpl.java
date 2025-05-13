package net.youhak.member.role.service;

import jakarta.transaction.Transactional;
import java.util.Optional;
import net.youhak.member.role.api.dto.request.RoleCategoryRegisterRequest;
import net.youhak.member.role.api.dto.request.RoleRegisterRequest;
import net.youhak.member.role.domain.Role;
import net.youhak.member.role.domain.RoleCategory;
import net.youhak.member.role.repository.RoleRepository;

public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public void roleCategoryRegister(final RoleCategoryRegisterRequest categoryRegisterRequest) {
        roleRepository.roleCategoryRegister(RoleCategory.builder()
                .name(categoryRegisterRequest.name())
                .build());
    }

    @Override
    public void roleCategoryDelete(final Long roleCategoryId) {
        roleRepository.roleCategoryDelete(roleCategoryId);
    }

    @Override
    @Transactional
    public void roleRegister(final RoleRegisterRequest registerRequest) {
        Optional<RoleCategory> categoryId = roleRepository.findByRoleCategoryId(registerRequest.categoryId());
        roleRepository.roleRegister(Role.builder()
                .name(registerRequest.name())
                .roleCategory(categoryId.get())
                .build());
    }

    @Override
    public void roleDelete(final Long roleId) {
        roleRepository.roleDelete(roleId);
    }
}
