package net.youhak.member.service;

import net.youhak.member.dto.request.RoleCategoryRegisterRequest;
import net.youhak.member.dto.request.RoleRegisterRequest;

public interface RoleService {

    void roleCategoryRegister(RoleCategoryRegisterRequest categoryRegisterRequest);

    void roleCategoryDelete(Long roleCategoryId);

    void roleRegister(RoleRegisterRequest registerRequest);

    void roleDelete(Long roleId);
}
