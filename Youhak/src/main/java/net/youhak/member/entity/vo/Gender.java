package net.youhak.member.entity.vo;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public enum Gender {

    NOT_SELECTED(0),
    MALE(1),
    FEMALE(2);

    private final int genderCode;

    Gender(int genderCode) {
        this.genderCode = genderCode;
    }

    private static final Map<Integer, Gender> GENDER_MAP = new HashMap<>();

    static {
        for (Gender gender : values()) {
            GENDER_MAP.put(gender.genderCode, gender);
        }
    }

    public static Gender getGender(int genderCode) {
        return GENDER_MAP.getOrDefault(genderCode, NOT_SELECTED);
    }
}
