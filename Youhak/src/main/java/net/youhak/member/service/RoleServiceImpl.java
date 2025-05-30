package net.youhak.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.youhak.member.dto.request.RoleCategoryRegisterRequest;
import net.youhak.member.dto.request.RoleRegisterRequest;
import net.youhak.member.entity.Role;
import net.youhak.member.entity.RoleCategory;
import net.youhak.member.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void roleCategoryRegister(final RoleCategoryRegisterRequest categoryRegisterRequest) {
        roleRepository.roleCategoryRegister(RoleCategory.builder()
                .name(categoryRegisterRequest.name())
                .build());
    }

    @Override
    @Transactional
    public void roleCategoryDelete(final Long roleCategoryId) {
        roleRepository.roleCategoryDelete(roleCategoryId);
    }

    @Override
    @Transactional
    public void roleRegister(final RoleRegisterRequest registerRequest) {
        RoleCategory categoryId = roleRepository.findByRoleCategoryId(registerRequest.categoryId());
        roleRepository.roleRegister(Role.builder()
                .name(registerRequest.name())
                .roleCategory(categoryId)
                .build());
    }

    @Override
    @Transactional
    public void roleDelete(final Long roleId) {
        roleRepository.roleDelete(roleId);
    }
}
