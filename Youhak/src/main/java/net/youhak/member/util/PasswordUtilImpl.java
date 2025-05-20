package net.youhak.member.util;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtilImpl implements PasswordUtil{

    @Override
    public String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    @Override
    public boolean verifyPassword(String password, String hashedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashedPassword);
        return result.verified;
    }
}
