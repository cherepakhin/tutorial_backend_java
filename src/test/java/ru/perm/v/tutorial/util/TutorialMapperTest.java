package ru.perm.v.tutorial.util;

import org.junit.jupiter.api.Test;
import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.entity.TutorialEntity;
import ru.perm.v.tutorial.mappers.TutorialMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TutorialMapperTest {

    @Test
    public void testFromEntityToDto() {
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
    public void testFromDtoToEntity() {
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
}