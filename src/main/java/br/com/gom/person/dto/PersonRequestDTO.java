package br.com.gom.person.dto;

import br.com.gom.person.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequestDTO {

    private String firstName;
    private String lastName;
    private String address;
    private GenderEnum gender;

}
