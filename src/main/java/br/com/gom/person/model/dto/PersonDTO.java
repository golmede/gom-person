package br.com.gom.person.model.dto;

import br.com.gom.person.model.enums.GenderEnum;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonDTO {

    @NotBlank(message = "AAAA")
    private String firstName;
    @NotBlank(message = "AAAA")
    private String lastName;
    @NotBlank(message = "AAAA")
    private String address;
    private GenderEnum gender;

}
