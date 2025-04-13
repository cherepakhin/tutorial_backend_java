package ru.perm.v.tutorial.util;

import org.junit.jupiter.api.Test;
import ru.perm.v.tutorial.dto.TutorialDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TutorialMapperTest {

    @Test
    public void testFromEntityToDto_Positive() {
//        ru.perm.v.companies.entity.TutorialEntity entity = new ru.perm.v.companies.entity.TutorialEntity();
//        entity.setN(1L);
//        entity.setShortname("ABC");
//        entity.setFullname("ABC Corporation");
//        entity.setInn("1234567890");
//        entity.setOgrn("0987654321");
//        entity.setAddressPost("123 Main St.");
//        entity.setAddressUr("456 Elm St.");
//        EmployeeEntity directorEntity = new EmployeeEntity();
//        directorEntity.setN(1L);
//        entity.setDirector(directorEntity);
//
//        TutorialDto dto = ru.perm.v.companies.mappers.TutorialMapper.fromEntityToDto(entity);
//
//        assertEquals(entity.getN(), dto.getN());
//        assertEquals(entity.getShortname(), dto.getShortname());
//        assertEquals(entity.getFullname(), dto.getFullname());
//        assertEquals(entity.getInn(), dto.getInn());
//        assertEquals(entity.getOgrn(), dto.getOgrn());
//        assertEquals(entity.getAddressPost(), dto.getAddressPost());
//        assertEquals(entity.getAddressUr(), dto.getAddressUr());
//        assertEquals(entity.getDirector().getN(), dto.getDirector().getN());
    }

    @Test
    public void testFromEntityToDto_NullEntity() {
//        ru.perm.v.companies.entity.TutorialEntity entity = null;
//
//        TutorialDto dto = ru.perm.v.companies.mappers.TutorialMapper.fromEntityToDto(entity);
//
//        assertNull(dto);
    }
}