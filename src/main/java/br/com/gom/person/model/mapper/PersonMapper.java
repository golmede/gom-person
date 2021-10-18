package br.com.gom.person.model.mapper;

import br.com.gom.person.model.dto.PersonDTO;
import br.com.gom.person.model.dto.PersonResponseDTO;
import br.com.gom.person.model.entity.PersonEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonMapper {

    private ModelMapper mapper;

    public PersonResponseDTO converterPersonEntityToPersonResponseDTO(PersonEntity personEntity) {
        return mapper.map(personEntity, PersonResponseDTO.class);
    }

    public PersonEntity converterPersonRequestDTOToPersonEntity(PersonDTO personDTO) {
        return mapper.map(personDTO, PersonEntity.class);
    }

    public PersonEntity converterPersonResponseDTOToPersonEntity(PersonResponseDTO personReesposeDTO) {
        return mapper.map(personReesposeDTO, PersonEntity.class);

    }
}
