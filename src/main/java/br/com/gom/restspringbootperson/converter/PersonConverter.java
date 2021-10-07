package br.com.gom.restspringbootperson.converter;

import br.com.gom.restspringbootperson.dto.PersonRequestDTO;
import br.com.gom.restspringbootperson.dto.PersonResponseDTO;
import br.com.gom.restspringbootperson.model.PersonEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonConverter {

    private ModelMapper mapper;

    public PersonResponseDTO converterPersonEntityToPersonResponseDTO(PersonEntity personEntity) {
        return mapper.map(personEntity, PersonResponseDTO.class);
    }

    public PersonEntity converterPersonRequestDTOToPersonEntity(PersonRequestDTO personRequestDTO) {
        return mapper.map(personRequestDTO, PersonEntity.class);
    }

    public PersonEntity converterPersonResponseDTOToPersonEntity(PersonResponseDTO personReesposeDTO) {
        return mapper.map(personReesposeDTO, PersonEntity.class);

    }
}
