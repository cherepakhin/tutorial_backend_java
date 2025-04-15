package ru.perm.v.tutorial.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.service.TutorialService;

import java.util.List;

@RestController
@RequestMapping("/tutorial")
public class TutorialRest {

    Logger log = LoggerFactory.getLogger(TutorialRest.class);

    private TutorialService tutorialService;

    public TutorialRest(@Autowired TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TutorialDto>> getAll() {
        log.info("get /tutorial/getAll");
        List<TutorialDto> dtos = tutorialService.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{n}")
    public ResponseEntity<TutorialDto> getByN(@PathVariable Long n) {
        log.info("------------------------");
        try {
            return ResponseEntity.ok(tutorialService.getByN(n));
        } catch (Exception e) {
            String errorMessage = String.format("Tutorial not found n=%s", n);
            log.error(errorMessage);
            return new ResponseEntity(errorMessage, HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/{n}")
    public ResponseEntity<String> deleteByN(@PathVariable Long n) {
        log.info(String.format("delete /tutorial/%d", n));
        try {
            tutorialService.getByN(n);
        } catch (Exception e) {
            String errorMessage = String.format("Tutorial not found n=%s", n);
            return new ResponseEntity(errorMessage, HttpStatus.BAD_GATEWAY);
        }
        try {
            tutorialService.deleteByN(n);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public ResponseEntity<TutorialDto> update(@RequestBody TutorialDto dto) {
        log.info(String.format("update /tutorial/%d", dto.getN()));
        try {
            tutorialService.getByN(dto.getN());
        } catch (Exception e) {
            String errorMessage = String.format("Tutorial not found n=%s", dto.getN());
            return new ResponseEntity(errorMessage, HttpStatus.BAD_GATEWAY);
        }
        try {
            tutorialService.update(dto);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
        return ResponseEntity.ok(dto);
    }

}
