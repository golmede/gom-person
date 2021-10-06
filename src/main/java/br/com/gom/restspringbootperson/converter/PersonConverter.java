package br.com.gom.restspringbootperson.converter;

import br.com.gom.restspringbootperson.dto.PersonRequestDTO;
import br.com.gom.restspringbootperson.dto.PersonResponseDTO;
import br.com.gom.restspringbootperson.model.PersonEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {

    private static ModelMapper mapper = new ModelMapper();

    public static PersonResponseDTO converterPersonEntityToPersonResponseDTO(PersonEntity personEntity) {
        return mapper.map(personEntity, PersonResponseDTO.class);
    }

    public static PersonEntity converterPersonRequestDTOToPersonEntity(PersonRequestDTO personRequestDTO) {
        return mapper.map(personRequestDTO, PersonEntity.class);
    }

    public static PersonEntity converterPersonResponseDTOToPersonEntity(PersonResponseDTO personReesposeDTO) {
        return mapper.map(personReesposeDTO, PersonEntity.class);

    }
}
