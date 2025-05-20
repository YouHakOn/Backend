package net.youhak.member.util;

public interface PasswordUtil {

    String hashPassword(String password);

    boolean verifyPassword(String password, String hashedPassword);
}
