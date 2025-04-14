package ru.perm.v.tutorial.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class TutorialDtoTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToString() {
        TutorialDto dto = new TutorialDto(1L,"TITLE", "DESCRIPTION", true);
        String s = dto.toString();

        assertEquals("TutorialDto{n=1, title='TITLE', description='DESCRIPTION', submitted=true}", s);
    }

    @Test
    void hashCodeEquals() {
        TutorialDto dto1 = new TutorialDto(1L,"TITLE", "DESCRIPTION", true);
        TutorialDto dto2 = new TutorialDto(1L,"TITLE", "DESCRIPTION", true);

        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
    @Test
    void hashCodeNotEquals() {
        TutorialDto dto1 = new TutorialDto(1L,"TITLE", "DESCRIPTION", true);
        TutorialDto dto2 = new TutorialDto(2L,"TITLE", "DESCRIPTION", true);

        assertNotEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testEquals() {
        TutorialDto dto1 = new TutorialDto(1L,"TITLE", "DESCRIPTION", true);
        TutorialDto dto2 = new TutorialDto(1L,"TITLE", "DESCRIPTION", true);

        assertEquals(dto1, dto2);
    }

    @Test
    void testNotEquals() {
        TutorialDto dto1 = new TutorialDto(1L,"TITLE", "DESCRIPTION", true);
        TutorialDto dto2 = new TutorialDto(2L,"TITLE", "DESCRIPTION", true);

        assertNotEquals(dto1, dto2);
    }

}

