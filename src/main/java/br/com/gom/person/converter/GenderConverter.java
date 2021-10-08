package br.com.gom.person.converter;

import br.com.gom.person.enums.GenderEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<GenderEnum, String> {


    @Override
    public String convertToDatabaseColumn(GenderEnum gender) {
        if (gender == null) return null;
        return gender.getGender();
    }

    @Override
    public GenderEnum convertToEntityAttribute(String gender) {
        if (gender == null) return null;
        return Stream.of(GenderEnum.values())
                .filter(g -> g.getGender().equals(gender))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
