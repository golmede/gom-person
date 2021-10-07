package br.com.gom.restspringbootperson.service;

import br.com.gom.restspringbootperson.converter.PersonConverter;
import br.com.gom.restspringbootperson.dto.PersonRequestDTO;
import br.com.gom.restspringbootperson.dto.PersonResponseDTO;
import br.com.gom.restspringbootperson.exception.NotFoundException;
import br.com.gom.restspringbootperson.model.PersonEntity;
import br.com.gom.restspringbootperson.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;
    private PersonConverter personConverter;

    public List<PersonResponseDTO> findAll() {
        return personRepository.findAll()
                .stream()
//                .map(PersonConverter::converterPersonEntityToPersonResponseDTO)
                .map(p -> personConverter.converterPersonEntityToPersonResponseDTO(p))
                .collect(Collectors.toList());
    }

    public PersonResponseDTO findById(Long id) {
        return personConverter.
                converterPersonEntityToPersonResponseDTO(
                        personRepository.findById(id)
                                .orElseThrow(() ->
                                        new NotFoundException("No record found for this ID")));
        // TODO: 06/10/2021 Por que no projeto do sijud lanca um throw new e aqui apenas o new?
    }

    public PersonResponseDTO create(PersonRequestDTO personRequestDTO) {
        return personConverter.
                converterPersonEntityToPersonResponseDTO(
                        personRepository.save(personConverter.converterPersonRequestDTOToPersonEntity(
                                personRequestDTO)));
    }

    public PersonResponseDTO update(Long id, PersonRequestDTO personRequestDTO) {
        PersonEntity personEntityOld = personConverter.
                converterPersonResponseDTOToPersonEntity(this.findById(id));
        PersonEntity personEntityNew = personConverter.
                converterPersonRequestDTOToPersonEntity(personRequestDTO);
        personEntityOld.setFirstName(personEntityNew.getFirstName());
        personEntityOld.setLastName(personEntityNew.getLastName());
        personEntityOld.setAddress(personEntityNew.getAddress());
        personEntityOld.setGender(personEntityNew.getGender());
        return personConverter.converterPersonEntityToPersonResponseDTO(
                personRepository.save(personEntityOld));
    }

    public void delete(Long id) {
        this.findById(id);
        personRepository.deleteById(id);
    }

}
