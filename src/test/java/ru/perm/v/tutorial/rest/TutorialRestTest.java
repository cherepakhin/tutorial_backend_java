package ru.perm.v.tutorial.rest;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.service.TutorialService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TutorialRestTest {

    TutorialService tutorialService = mock(TutorialService.class);

    @Test
    public void getAll() {
        TutorialDto dto1 = new TutorialDto(1L, "TITLE1", "DESCRIPTION1", true);
        TutorialDto dto2 = new TutorialDto(2L, "TITLE2", "DESCRIPTION2", false);
        when(tutorialService.getAll()).thenReturn(List.of(dto1, dto2));
        TutorialRest tutorialRest = new TutorialRest(tutorialService);

        ResponseEntity<List<TutorialDto>> response = tutorialRest.getAll();
        List<TutorialDto> dtos = response.getBody();

        assertEquals(2, dtos.size());
        assertEquals(dto1, dtos.get(0));
        assertEquals(dto2, dtos.get(1));
    }

//    @Test
//    void getById() throws Exception {
//        Long N = 100L;
//        TutorialDto dto1 = new TutorialDto(N, "TITLE1", "DESCRIPTION1", true);
//
//        when(tutorialService.getByN(N)).thenReturn(dto1);
//        TutorialRest tutorialRest = new TutorialRest(tutorialService);
//        ResponseEntity<TutorialDto> response = tutorialRest.getByN(N);
//
//        assertEquals(new ResponseEntity<>(dto1, HttpStatus.OK), response);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(dto1, response.getBody());
//    }

    @Test
    void getByTitle() {
        String TITLE = "TITLE1";
        TutorialDto dto1 = new TutorialDto(100L, TITLE, "DESCRIPTION1", true);
        when(tutorialService.getByTitle("TITLE1")).thenReturn(List.of(dto1));
        TutorialRest tutorialRest = new TutorialRest(tutorialService);

        ResponseEntity<List<TutorialDto>> response = tutorialRest.getByTitle(TITLE);

        List<TutorialDto> dtos = response.getBody();

        assertEquals(1, dtos.size());
        assertEquals(dto1, dtos.get(0));
    }

    @Test
    public void deleteTutorial() throws Exception {
        Long N = 100L;
        TutorialDto dto1 = new TutorialDto(N, "TITLE1", "DESCRIPTION1", true);
        when(tutorialService.getByN(N)).thenReturn(dto1);
        TutorialRest tutorialRest = new TutorialRest(tutorialService);

        ResponseEntity<String> response = tutorialRest.deleteByN(N);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void update() throws Exception {
        Long N = 100L;
        TutorialDto dto1 = new TutorialDto(N, "TITLE1", "DESCRIPTION1", true);
        when(tutorialService.getByN(N)).thenReturn(dto1);
        TutorialRest tutorialRest = new TutorialRest(tutorialService);

        ResponseEntity<TutorialDto> response = tutorialRest.update(N, dto1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(tutorialService, times(1)).getByN(N);
        verify(tutorialService, times(1)).update(dto1);
    }

    @Test
    public void updateForNullTutorialCheckCode() {
        TutorialRest tutorialRest = new TutorialRest(tutorialService);
        ResponseEntity<?> response = tutorialRest.update(1L, null);

        assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
    }

    @Test
    public void updateForNullTutorialCheckMessage() {
        TutorialRest tutorialRest = new TutorialRest(tutorialService);
        ResponseEntity<?> response = tutorialRest.update(1L, null);

        assertEquals("Null TutorialDto for update.", response.getBody());
    }

    @Test
    public void updateForNotExistTutorial() throws Exception {
        Long N = 100L;
        TutorialDto dto1 = new TutorialDto(N, "TITLE1", "DESCRIPTION1", true);
        when(tutorialService.update(dto1)).thenThrow(new Exception("ERROR"));
        TutorialRest tutorialRest = new TutorialRest(tutorialService);
        ResponseEntity<?> response = tutorialRest.update(N, dto1);

        assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
        assertEquals("ERROR", response.getBody());
    }
}