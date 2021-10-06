package br.com.gom.restspringbootperson.controller;

import br.com.gom.restspringbootperson.dto.PersonRequestDTO;
import br.com.gom.restspringbootperson.dto.PersonResponseDTO;
import br.com.gom.restspringbootperson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> findAll() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> create(@RequestBody PersonRequestDTO personRequestDTO) {
        return new ResponseEntity(personService.create(personRequestDTO), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@PathVariable(name = "id") Long id,
                                                    @RequestBody PersonRequestDTO personRequestDTO) {
        return new ResponseEntity(personService.update(id, personRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    // TODO: 06/10/2021 Ajustar assinatura do metodo para melhor padrao de retorno NO_CONTENT
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        personService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
        // TODO: 06/10/2021 Verificar a resposta do professor para ajustar este codigo
//        return ResponseEntity.ok().build();
    }

}
