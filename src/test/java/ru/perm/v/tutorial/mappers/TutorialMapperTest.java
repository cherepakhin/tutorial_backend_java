package ru.perm.v.tutorial.mappers;

import org.junit.jupiter.api.Test;
import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.entity.TutorialEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TutorialMapperTest {

    @Test
    void testFromEntityToDto() {
        TutorialEntity entity = new TutorialEntity();
        entity.setN(1L);
        entity.setTitle("TITLE");
        entity.setDescription("DESCRIPTION");
        entity.setSubmitted(true);

        TutorialDto dto = TutorialMapper.fromEntityToDto(entity);

        assertEquals(entity.getN(), dto.getN());
        assertEquals(entity.getTitle(), dto.getTitle());
        assertEquals(entity.getDescription(), dto.getDescription());
        assertEquals(entity.getSubmitted(), dto.getSubmitted());
    }

    @Test
    void testFromDtoToEntity() {
        TutorialDto dto = new TutorialDto();
        dto.setN(1L);
        dto.setTitle("TITLE");
        dto.setDescription("DESCRIPTION");
        dto.setSubmitted(true);

        TutorialEntity entity = TutorialMapper.fromDtoToEntity(dto);

        assertEquals(dto.getN(), entity.getN());
        assertEquals(dto.getTitle(), entity.getTitle());
        assertEquals(dto.getDescription(), entity.getDescription());
        assertEquals(dto.getSubmitted(), entity.getSubmitted());
    }

    @Test
    void fromListEntityToListDto() {
        TutorialEntity entity1 = new TutorialEntity();
        entity1.setN(1L);
        TutorialEntity entity2 = new TutorialEntity();
        entity2.setN(2L);
        List<TutorialEntity> entities = List.of(entity1, entity2);

        List<TutorialDto> dtos = TutorialMapper.fromListEntityToListDto(entities);

        assertEquals(2, dtos.size());
        assertEquals(Long.valueOf(1), dtos.get(0).getN());
        assertEquals(Long.valueOf(2), dtos.get(1).getN());
    }

    @Test
    void fromListDtoToListEntity() {
        TutorialDto dto1 = new TutorialDto();
        dto1.setN(1L);
        TutorialDto dto2 = new TutorialDto();
        dto2.setN(2L);
        List<TutorialDto> dtos = List.of(dto1, dto2);

        List<TutorialEntity> entites = TutorialMapper.fromListDtoToListEntity(dtos);

        assertEquals(2, entites.size());
        assertEquals(Long.valueOf(1L), entites.get(0).getN());
        assertEquals(Long.valueOf(2L), entites.get(1).getN());
    }

    @Test
    void forEmptyDTOs() {
        List<TutorialDto> dtos = new ArrayList<>();

        List<TutorialEntity> entities = TutorialMapper.fromListDtoToListEntity(dtos);

        assertNotNull(entities);
        assertEquals(0, entities.size());
    }

    @Test
    void forEmptyEntites() {
        List<TutorialEntity> entities= new ArrayList<>();

        List<TutorialDto> dtos = TutorialMapper.fromListEntityToListDto(entities);

        assertNotNull(dtos);
        assertEquals(0, dtos.size());
    }
}