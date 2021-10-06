package br.com.gom.restspringbootperson.service;

import br.com.gom.restspringbootperson.converter.PersonConverter;
import br.com.gom.restspringbootperson.dto.PersonRequestDTO;
import br.com.gom.restspringbootperson.dto.PersonResponseDTO;
import br.com.gom.restspringbootperson.exception.NotFoundException;
import br.com.gom.restspringbootperson.model.PersonEntity;
import br.com.gom.restspringbootperson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    //    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private PersonRepository personRepository;

    public List<PersonResponseDTO> findAll() {
        return personRepository.findAll()
                .stream()
                .map(PersonConverter::converterPersonEntityToPersonResponseDTO)
                .collect(Collectors.toList());
    }

    public PersonResponseDTO findById(Long id) {
        return PersonConverter.
                converterPersonEntityToPersonResponseDTO(
                        personRepository.findById(id)
                                .orElseThrow(() ->
                                        new NotFoundException("No record found for this ID")));
        // TODO: 06/10/2021 Esta retornando status code 500 e nao o 404 quando nao encontra
        // TODO: 06/10/2021 Por que no projeto do sijud lanca um throw new e aqui apenas o new?
    }

    public PersonResponseDTO create(PersonRequestDTO personRequestDTO) {
        return PersonConverter.
                converterPersonEntityToPersonResponseDTO(
                        personRepository.save(PersonConverter.converterPersonRequestDTOToPersonEntity(
                                personRequestDTO)));
    }

    public PersonResponseDTO update(Long id, PersonRequestDTO personRequestDTO) {
        PersonEntity personEntityOld = PersonConverter.
                converterPersonResponseDTOToPersonEntity(this.findById(id));
        PersonEntity personEntityNew = PersonConverter.
                converterPersonRequestDTOToPersonEntity(personRequestDTO);
        personEntityOld.setFirstName(personEntityNew.getFirstName());
        personEntityOld.setLastName(personEntityNew.getLastName());
        personEntityOld.setAddress(personEntityNew.getAddress());
        personEntityOld.setGender(personEntityNew.getGender());
        return PersonConverter.converterPersonEntityToPersonResponseDTO(
                personRepository.save(personEntityOld));
    }

    public void delete(Long id) {
        this.findById(id);
        personRepository.deleteById(id);
    }

}
