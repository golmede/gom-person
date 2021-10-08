package br.com.gom.restspringbootperson.controller;

import br.com.gom.restspringbootperson.dto.PersonRequestDTO;
import br.com.gom.restspringbootperson.dto.PersonResponseDTO;
import br.com.gom.restspringbootperson.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
@AllArgsConstructor
public class PersonController {

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
    public ResponseEntity<PersonResponseDTO> create(@RequestBody PersonRequestDTO personRequestDTO) {
        return ResponseEntity
                .ok(personService.create(personRequestDTO));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@PathVariable(name = "id") Long id,
                                                    @RequestBody PersonRequestDTO personRequestDTO) {
        return ResponseEntity
                .ok(personService.update(id, personRequestDTO));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        personService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}
