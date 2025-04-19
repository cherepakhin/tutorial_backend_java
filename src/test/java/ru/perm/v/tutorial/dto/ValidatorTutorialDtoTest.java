package ru.perm.v.tutorial.dto;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTutorialDtoTest {

    @Test
    void validateEmptyTitle() {
        TutorialDto tutorialDto = new TutorialDto();
        tutorialDto.setTitle("");
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<TutorialDto>> violations = validator.validate(tutorialDto);
        HashMap<String, String> errors = new HashMap<>();
        violations.forEach(violation ->
                errors.put(violation.getPropertyPath().toString(), violation.getMessage())
        );
        assertEquals(1, errors.size());
        assertEquals("The Title should not be empty.", errors.get("title"));
    }
}