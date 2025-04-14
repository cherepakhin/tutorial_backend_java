package ru.perm.v.tutorial.service;

import ru.perm.v.tutorial.dto.TutorialDto;

import java.util.List;

//TODO: modify
public interface TutorialService {
    List<TutorialDto> getAll();

    TutorialDto getByN(Long n) throws Exception;

    List<TutorialDto> getByTitle(String title);

    void deleteByN(Long id) throws Exception;

    TutorialDto update(TutorialDto tutorialDto) throws Exception;
}
