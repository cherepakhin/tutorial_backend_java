package ru.perm.v.tutorial.service.impl;

import org.junit.jupiter.api.Test;
import ru.perm.v.tutorial.critery.TutorialCritery;
import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.entity.TutorialEntity;
import ru.perm.v.tutorial.repository.TutorialRepository;
import ru.perm.v.tutorial.service.TutorialService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TutorialServiceImplTest {
    TutorialRepository tutorialRepository = mock(TutorialRepository.class);

    @Test
    void getAll() {
        TutorialDto dto1 = new TutorialDto(1L);
        TutorialDto dto2 = new TutorialDto(2L);

        TutorialEntity entity1 = new TutorialEntity(1L);
        TutorialEntity entity2 = new TutorialEntity(2L);
        when(tutorialRepository.findAll()).thenReturn(List.of(entity1, entity2));

        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);

        assertEquals(2, tutorialService.getAll().size());
    }

    @Test
    void getAll_asList() {
        TutorialEntity entity1 = new TutorialEntity(1L);
        TutorialEntity entity2 = new TutorialEntity(2L);
        when(tutorialRepository.findAll()).thenReturn(Arrays.asList(entity1, entity2));

        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);

        List<TutorialDto> tutors = tutorialService.getAll();
        assertEquals(2, tutors.size());

        TutorialDto dto1 = new TutorialDto(1L);
        TutorialDto dto2 = new TutorialDto(2L);
        assertEquals(dto1, tutors.get(0));
        assertEquals(dto2, tutors.get(1));
    }


    @Test
    void getByN() {
        Long N = 1L;
        TutorialEntity entity1 = new TutorialEntity(N);
        when(tutorialRepository.findById(N)).thenReturn(Optional.of(entity1));

        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);

        TutorialDto tutor = null;
        try {
            tutor = tutorialService.getByN(N);
        } catch (Exception e) {
            fail();
        }

        assertEquals(N, tutor.getN());
    }

    @Test
    void notFoundGetByN() {
        Long ID = 2L;
        when(tutorialRepository.findById(ID)).thenReturn(Optional.empty());
        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);
        Exception excpt = null;

        try {
            tutorialService.getByN(ID);
        } catch (Exception e) {
            excpt = e;
        }

        assertNotNull(excpt);
        assertEquals("Tutorial with id=2 NOT FOUND", excpt.getMessage());
    }

    @Test
    void getByTitle() {
        String TITLE = "TITLE";
        List<TutorialEntity> entities = List.of(new TutorialEntity(1L), new TutorialEntity(2L));
        when(tutorialRepository.findByTitleOrderByNDesc(TITLE)).thenReturn(entities);
        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);

        List<TutorialDto> dtos = tutorialService.getByTitle(TITLE);

        assertEquals(2, dtos.size());

        assertEquals(Long.valueOf(1), dtos.get(0).getN());
        assertEquals(Long.valueOf(2), dtos.get(1).getN());
    }

    @Test
    void deleteByN_forExist() {
        long N = 2L;
        TutorialEntity entity = new TutorialEntity(1L);
        when(tutorialRepository.getOne(N)).thenReturn(entity);
        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);

        try {
            tutorialService.deleteByN(N);
        } catch (Exception e) {
            fail();
        }

        verify(tutorialRepository, times(1)).deleteById(N);
    }

    @Test
    void deleteByN_forNotExist() {
        long N = 2L;
        when(tutorialRepository.getOne(N)).thenReturn(null);
        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);

        Exception excpt = null;
        try {
            tutorialService.deleteByN(N);
        } catch (Exception e) {
            excpt = e;
        }

        verify(tutorialRepository, never()).deleteById(N);
        assertNotNull(excpt);
        assertEquals("Tutorial with n=2 not found.", excpt.getMessage());
    }

    @Test
    void updateForNullDto() {
        TutorialDto tutorialDto = null;
        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);
        Exception exception = null;
        try {
            tutorialService.update(tutorialDto);
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("TutorialDto is null", exception.getMessage());
    }

    @Test
    void updateForNull_N_Dto() {
        TutorialDto tutorialDto = new TutorialDto();
        tutorialDto.setN(null);
        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);
        Exception exception = null;
        try {
            tutorialService.update(tutorialDto);
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("N TutorialDto is null", exception.getMessage());
    }

    @Test
    void updateForNull_TITLE_Dto() {
        TutorialDto tutorialDto = new TutorialDto();
        tutorialDto.setN(1L);
        tutorialDto.setTitle(null);
        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);
        Exception exception = null;
        try {
            tutorialService.update(tutorialDto);
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Title TutorialDto is null", exception.getMessage());
    }

    @Test
    void updateForNull_DESCRIPTION_Dto() {
        TutorialDto tutorialDto = new TutorialDto();
        tutorialDto.setN(1L);
        tutorialDto.setTitle("TITLE");
        tutorialDto.setDescription(null);
        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);
        Exception exception = null;
        try {
            tutorialService.update(tutorialDto);
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Description TutorialDto is null", exception.getMessage());
    }

    @Test
    void updateForNotExistTutorial() {
        TutorialDto tutorialDto = new TutorialDto();
        Long N = 1L;
        tutorialDto.setN(N);
        tutorialDto.setTitle("TITLE");
        tutorialDto.setDescription("DESCRIPTION");

        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);
        when(tutorialRepository.getOne(N)).thenReturn(null);
        Exception exception = null;
        try {
            tutorialService.update(tutorialDto);
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Tutorial with n=1 not found.", exception.getMessage());
    }

    @Test
    void update() {
        TutorialDto tutorialDto = new TutorialDto();
        Long N = 1L;
        tutorialDto.setN(N);
        tutorialDto.setTitle("TITLE");
        tutorialDto.setDescription("DESCRIPTION");

        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);
        TutorialEntity entity = new TutorialEntity();
        entity.setN(N);
        entity.setTitle("TITLE");
        entity.setDescription("DESCRIPTION");
        entity.setSubmitted(true);
        when(tutorialRepository.getOne(N)).thenReturn(entity);
        when(tutorialRepository.saveAndFlush(entity)).thenReturn(entity);
        Exception exception = null;
        TutorialDto updatedDto = null;
        try {
            updatedDto = tutorialService.update(tutorialDto);
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(updatedDto);
        assertNull(exception);
        assertEquals(new TutorialDto(N, "TITLE", "DESCRIPTION", false), updatedDto);
        verify(tutorialRepository, times(1)).saveAndFlush(entity);
    }

}
