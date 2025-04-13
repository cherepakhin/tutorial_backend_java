package ru.perm.v.tutorial.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.service.TutorialService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TutorialServiceImpl_IntegrationTest {

    @Autowired
    TutorialService tutorialService;

    @Test
    public void getAll() {
        List<TutorialDto> tutors = tutorialService.getAll();
        assertNotNull(tutors);
        assertEquals(3, tutors.size());
    }

    @Test
    public void getByN() throws Exception {
        TutorialDto tutorialDto = tutorialService.getByN(1L);
        assertEquals(1L, tutorialDto.getN().longValue());
    }

//    @Test
//    public void getByNotExistN() throws Exception {
//        String errorMessage = "";
//        try {
//            tutorialService.getByN(-100L);
//        } catch (Exception excp) {
//            errorMessage = excp.getMessage();
//        }
//        assertEquals("Company with id=-100 NOT FOUND", errorMessage);
//    }
//
//    @Test
//    public void getByN_by_N1() throws Exception {
//        TutorialDto company = tutorialService.getByN(1L);
//        assertEquals(1, company.getN());
//    }
//
//    @Test
//    public void getByTitle() {
//        String TITLE = "TITLE_1";
//        List<TutorialDto> dtos = tutorialService.getByTitle(TITLE);
//        for (TutorialDto t : dtos) {
//            System.out.println(t.getN());
//        }
//        assertEquals(1, dtos.size());
//        assertEquals(TITLE, dtos.get(0).getTitle());
//    }
}
