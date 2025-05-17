package net.youhak.member.role.service;

import net.youhak.member.role.api.dto.request.RoleCategoryRegisterRequest;
import net.youhak.member.role.api.dto.request.RoleRegisterRequest;

public interface RoleService {

    void roleCategoryRegister(RoleCategoryRegisterRequest categoryRegisterRequest);

    void roleCategoryDelete(Long roleCategoryId);

    void roleRegister(RoleRegisterRequest registerRequest);

    void roleDelete(Long roleId);
}
