package br.com.gom.person.model.dto;

import br.com.gom.person.model.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonPropertyOrder({"firstName", "lastName", "gender", "address"})
public class PersonDTO {

    @NotBlank(message = "AAAA")
//    @JsonProperty("first_name")
    private String firstName;
    @NotBlank(message = "AAAA")
    private String lastName;
    @NotBlank(message = "AAAA")
    private String address;
    private GenderEnum gender;

}
