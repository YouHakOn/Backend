package net.youhak.member.dto.request;

public record RoleRegisterRequest(
        String name,
        Long categoryId
) {
}
