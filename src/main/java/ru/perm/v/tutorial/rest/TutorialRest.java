package ru.perm.v.tutorial.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.perm.v.tutorial.dto.TutorialDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ru.perm.v.tutorial.service.TutorialService;

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
        log.info("get /company/getAll");
//        List<TutorialDto> dtos = tutorialService
//                .getAll()
//                .stream()
//                .map(c -> new TutorialDto(
//                        c.getN(),
//                        c.getShortname(),
//                        c.getFullname(),
//                        c.getInn(),
//                        c.getOgrn(),
//                        c.getAddressPost(),
//                        c.getAddressUr(),
//                        c.getDirector()
//                ) {
//                })
//                .collect(Collectors.toList());
        List<TutorialDto> dtos = new ArrayList<>();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorialDto> getById(@PathVariable Long id) {
        log.info("------------------------");
        log.info(String.format("get /company/getById/%d", id));

        String errorMessage = String.format("Tutorial not found id=%s", id);
        log.error(errorMessage);
        return new ResponseEntity(errorMessage, HttpStatus.BAD_GATEWAY);
//        try {
//            return ResponseEntity.ok(tutorialService.getByN(id));
//        } catch (Exception e) {
//            String errorMessage = String.format("Company not found id=%s", id);
//            log.error(errorMessage);
//            return new ResponseEntity(errorMessage, HttpStatus.BAD_GATEWAY);
//        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
//        log.info(String.format("delete /company/deleteById/%d", id));
//        try {
//            companyService.deleteById(id);
//            return ResponseEntity.ok(id);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
            return new ResponseEntity("ERROR TEXT", HttpStatus.BAD_GATEWAY);
//        }
    }

}
