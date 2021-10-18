package br.com.gom.person.controller;

import br.com.gom.person.model.dto.PersonDTO;
import br.com.gom.person.model.dto.PersonResponseDTO;
import br.com.gom.person.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/person")
@AllArgsConstructor
@NoArgsConstructor
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> findAll() {
        return ResponseEntity
                .ok(personService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity
                .ok(personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> create(@Valid @RequestBody PersonDTO personDTO) {
        return ResponseEntity
                .ok(personService.create(personDTO));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@PathVariable(name = "id") @Valid Long id,
                                                    @RequestBody PersonDTO personDTO) {
        return ResponseEntity
                .ok(personService.update(id, personDTO));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        personService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}
