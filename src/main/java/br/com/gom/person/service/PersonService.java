package br.com.gom.person.service;

import br.com.gom.person.converter.PersonConverter;
import br.com.gom.person.dto.PersonRequestDTO;
import br.com.gom.person.dto.PersonResponseDTO;
import br.com.gom.person.exception.NotFoundException;
import br.com.gom.person.model.PersonEntity;
import br.com.gom.person.repository.PersonRepository;
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
                .map(p -> personConverter.converterPersonEntityToPersonResponseDTO(p))
                .collect(Collectors.toList());
    }

    public PersonResponseDTO findById(Long id) {
        return personConverter.
                converterPersonEntityToPersonResponseDTO(
                        personRepository.findById(id)
                                .orElseThrow(() ->
                                        new NotFoundException("No record found for this ID")));
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
