package net.youhak.member.role.api;

import lombok.RequiredArgsConstructor;
import net.youhak.member.role.api.dto.request.RoleCategoryRegisterRequest;
import net.youhak.member.role.api.dto.request.RoleRegisterRequest;
import net.youhak.member.role.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/role")
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/category")
    public ResponseEntity<Void> registerRoleCategory(@RequestBody RoleCategoryRegisterRequest categoryRegisterRequest) {
        roleService.roleCategoryRegister(categoryRegisterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteRoleCategory(@PathVariable("id") Long roleCategoryId) {
        roleService.roleCategoryDelete(roleCategoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<Void> registerRole(@RequestBody RoleRegisterRequest roleRegisterRequest) {
        roleService.roleRegister(roleRegisterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable("id") Long roleId) {
        roleService.roleDelete(roleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
