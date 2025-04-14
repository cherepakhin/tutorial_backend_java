package ru.perm.v.tutorial.mappers;


import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.entity.TutorialEntity;

import java.util.ArrayList;
import java.util.List;

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

    public static List<TutorialDto> fromListEntityToListDto(List<TutorialEntity> entityList) {
        List<TutorialDto> dtos = new ArrayList<>();
        for(TutorialEntity entity: entityList) {
            dtos.add(fromEntityToDto(entity));
        }
        return dtos;
    }

    public static List<TutorialEntity> fromListDtoToListEntity(List<TutorialDto> dtos) {
        List<TutorialEntity> entites = new ArrayList<>();
        for(TutorialDto dto : dtos) {
            TutorialEntity entity = fromDtoToEntity(dto);
            entites.add(entity);
        }
        return entites;
    }
}
