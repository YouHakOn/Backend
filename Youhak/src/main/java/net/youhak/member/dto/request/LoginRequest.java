package net.youhak.member.dto.request;

public record LoginRequest(
        String email,
        String password
) {
}
