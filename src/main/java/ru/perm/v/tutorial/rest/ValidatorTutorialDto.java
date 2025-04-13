package ru.perm.v.tutorial.rest;

import ru.perm.v.tutorial.dto.TutorialDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidatorTutorialDto {
    public List<String> validate(TutorialDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.usingContext().getValidator();
        Set<ConstraintViolation<TutorialDto>> validates = validator.validate(dto);
        List<String> ret = new ArrayList<>();
        if (validates.size() > 0) {
            List<ConstraintViolation<TutorialDto>> errors = validates.stream().collect(Collectors.toList());
            for (ConstraintViolation<TutorialDto> validateErr : errors) {
                ret.add(String.format("field: %s, error: %s", validateErr.getPropertyPath(), validateErr.getMessage()));
            }
        }
        return ret;
    }
}
