package net.youhak.member.entity.vo;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        return gender != null ? gender.getGenderCode() : Gender.NOT_SELECTED.getGenderCode();
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
        return dbData != null ? Gender.getGender(dbData) : Gender.NOT_SELECTED;
    }
}
