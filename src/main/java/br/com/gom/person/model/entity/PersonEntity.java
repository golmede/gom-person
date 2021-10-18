package br.com.gom.person.model.entity;

import br.com.gom.person.model.enums.GenderEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "person")
@Entity
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Field firstName is null or empty")
    @Column(name = "first_name",
            nullable = false,
            length = 30)
    private String firstName;

    @NotBlank(message = "Field lastName is null or empty")
    @Column(name = "last_name",
            nullable = false,
            length = 50)
    private String lastName;

    @NotBlank(message = "Field address is null or empty")
    @Column(nullable = false,
            length = 100)
    private String address;

    @NotBlank(message = "Field gender is null or empty")
    private GenderEnum gender;

    public PersonEntity(String firstName, String lastName, String address, GenderEnum gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

}
