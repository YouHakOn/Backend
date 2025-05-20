package net.youhak.member.role.api.dto.request;

public record RoleRegisterRequest(
        String name,
        Long categoryId
) {
}
