package br.com.gom.person.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderEnum {

    M("Male"),
    F("Female");

    private String gender;

}
