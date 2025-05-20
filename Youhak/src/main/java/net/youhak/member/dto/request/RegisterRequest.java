package net.youhak.member.dto.request;

public record RegisterRequest(
        String email,
        String password,
        String name,
        String nickname,
        int gender
) {
}
