package ru.perm.v.tutorial.mappers;


import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.entity.TutorialEntity;

public class TutorialMapper {
    public static TutorialEntity fromDtoToEntity(TutorialDto dto) {
        TutorialEntity tutorialEntity = new TutorialEntity();
        tutorialEntity.setN(dto.getN());
        tutorialEntity.setTitle(dto.getTitle());
        tutorialEntity.setDescription(dto.getDescription());
        tutorialEntity.setSubmitted(dto.getSubmitted());
        return tutorialEntity;
    }

    public static TutorialDto fromEntityToDto(TutorialEntity entity) {
        if (entity == null) return null;
        TutorialDto dto = new TutorialDto();
        dto.setN(entity.getN());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setSubmitted(entity.getSubmitted());
        return dto;
    }
}
