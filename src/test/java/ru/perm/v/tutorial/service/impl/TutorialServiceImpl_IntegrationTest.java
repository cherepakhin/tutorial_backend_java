package ru.perm.v.tutorial.service.impl;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ru.perm.v.tutorial.critery.TutorialCritery;
import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.service.TutorialService;

import java.util.List;
import java.util.logging.Logger;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class TutorialServiceImpl_IntegrationTest {

    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    TutorialService tutorialService;

    @Test
    public void getAll() {
        List<TutorialDto> tutors = tutorialService.getAll();
        logger.info(tutors.toString());
        assertNotNull(tutors);

        assertEquals(2, tutors.size());
    }

    @Test
    public void getByN() throws Exception {
        TutorialDto tutorialDto = tutorialService.getByN(1L);
        assertEquals(new TutorialDto(1L, "title 1", "description 1", true), tutorialDto);
    }

    @Test
    public void getByNotExistN() throws Exception {
        String errorMessage = "";
        try {
            tutorialService.getByN(-100L);
        } catch (Exception excp) {
            errorMessage = excp.getMessage();
        }
        assertEquals("Tutorial with id=-100 NOT FOUND", errorMessage);
    }

    @Test
    public void getByNn() {
        TutorialCritery critery = new TutorialCritery();
        critery.setNn(List.of(1L));

        List<TutorialDto> tutors = tutorialService.getBySpecification(critery);

        assertEquals(1, tutors.size());
        TutorialDto dto = tutors.get(0);
        assertEquals(Long.valueOf(1), dto.getN());
    }

    @Test
    public void getBySpecificationForEqTitle() {
        TutorialCritery critery = new TutorialCritery();
        critery.setTitle("title 1");
        List<TutorialDto> tutors = tutorialService.getBySpecification(critery);

        assertEquals(1, tutors.size());
        TutorialDto dto = tutors.get(0);
        assertEquals(Long.valueOf(1), dto.getN());
    }

    @Test
    public void getBySpecificationForLikeTitle() {
        TutorialCritery critery = new TutorialCritery();
        critery.setTitle("title%");
        List<TutorialDto> tutors = tutorialService.getBySpecification(critery);

        assertEquals(2, tutors.size());
        assertEquals(Long.valueOf(1), tutors.get(0).getN());
        assertEquals(Long.valueOf(2), tutors.get(1).getN());
    }

    @Test
    public void getBySpecificationForNn() {
        TutorialCritery critery = new TutorialCritery();
        critery.setNn(List.of(1L, 2L));
        List<TutorialDto> tutors = tutorialService.getBySpecification(critery);

        assertEquals(2, tutors.size());
        assertEquals(Long.valueOf(1), tutors.get(0).getN());
        assertEquals(Long.valueOf(2), tutors.get(1).getN());
    }

    @Test
    public void getBySpecificationForN() {
        TutorialCritery critery = new TutorialCritery();
        critery.setNn(List.of(1L));
        List<TutorialDto> tutors = tutorialService.getBySpecification(critery);

        assertEquals(1, tutors.size());
        assertEquals(Long.valueOf(1), tutors.get(0).getN());
    }

    @Test
    public void getBySpecificationForDescription() {
        TutorialCritery critery = new TutorialCritery();
        critery.setDescription("description 1");
        List<TutorialDto> tutors = tutorialService.getBySpecification(critery);

        assertEquals(1, tutors.size());
        assertEquals(Long.valueOf(1), tutors.get(0).getN());
    }

    @Test
    public void getBySpecificationForLikeDescription() {
        TutorialCritery critery = new TutorialCritery();
        critery.setDescription("%description%");
        List<TutorialDto> tutors = tutorialService.getBySpecification(critery);

        assertEquals(2, tutors.size());
        assertEquals(Long.valueOf(1), tutors.get(0).getN());
        assertEquals(Long.valueOf(2), tutors.get(1).getN());
    }

    @Test
    public void getByTitle() {
        TutorialCritery critery = new TutorialCritery();
        critery.setTitle("title 1");
        List<TutorialDto> tutors = tutorialService.getBySpecification(critery);

        assertEquals(1, tutors.size());
        assertEquals(Long.valueOf(1), tutors.get(0).getN());
    }
}
