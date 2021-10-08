package br.com.gom.person.model;

import br.com.gom.person.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "person")
@Entity
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",
            nullable = false,
            length = 30)
    private String firstName;

    @Column(name = "last_name",
            nullable = false,
            length = 50)
    private String lastName;

    @Column(nullable = false,
            length = 100)
    private String address;

    private GenderEnum gender;

    public PersonEntity() {
    }

    public PersonEntity(String firstName, String lastName, String address, GenderEnum gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

}
