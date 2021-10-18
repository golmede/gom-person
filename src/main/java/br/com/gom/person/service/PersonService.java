package br.com.gom.person.service;

import br.com.gom.person.exception.NotFoundException;
import br.com.gom.person.model.dto.PersonDTO;
import br.com.gom.person.model.dto.PersonResponseDTO;
import br.com.gom.person.model.entity.PersonEntity;
import br.com.gom.person.model.mapper.PersonMapper;
import br.com.gom.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    public List<PersonResponseDTO> findAll() {
        return personRepository.findAll()
                .stream()
                .map(p -> personMapper.converterPersonEntityToPersonResponseDTO(p))
                .collect(Collectors.toList());
    }

    public PersonResponseDTO findById(Long id) {
        return personMapper.
                converterPersonEntityToPersonResponseDTO(
                        personRepository.findById(id)
                                .orElseThrow(() ->
                                        new NotFoundException("No record found for this ID")));
    }

    public PersonResponseDTO create(PersonDTO personDTO) {
        return personMapper.
                converterPersonEntityToPersonResponseDTO(
                        personRepository.save(personMapper.converterPersonRequestDTOToPersonEntity(
                                personDTO)));
    }

    public PersonResponseDTO update(Long id, PersonDTO personDTO) {
        PersonEntity personEntityOld = personMapper.
                converterPersonResponseDTOToPersonEntity(this.findById(id));
        PersonEntity personEntityNew = personMapper.
                converterPersonRequestDTOToPersonEntity(personDTO);
        personEntityOld.setFirstName(personEntityNew.getFirstName());
        personEntityOld.setLastName(personEntityNew.getLastName());
        personEntityOld.setAddress(personEntityNew.getAddress());
        personEntityOld.setGender(personEntityNew.getGender());
        return personMapper.converterPersonEntityToPersonResponseDTO(
                personRepository.save(personEntityOld));
    }

    public void delete(Long id) {
        this.findById(id);
        personRepository.deleteById(id);
    }

}
