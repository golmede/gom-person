package br.com.gom.person.converter;

import br.com.gom.person.dto.PersonRequestDTO;
import br.com.gom.person.dto.PersonResponseDTO;
import br.com.gom.person.model.PersonEntity;
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
