package ru.perm.v.tutorial.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.entity.TutorialEntity;
import ru.perm.v.tutorial.mappers.TutorialMapper;
import ru.perm.v.tutorial.repository.TutorialRepository;
import ru.perm.v.tutorial.service.TutorialService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class TutorialServiceImpl implements TutorialService {

    private static TutorialDto nullTutorial = new TutorialDto(-1L);
    Logger log = LoggerFactory.getLogger(TutorialServiceImpl.class);

    @Autowired
    private TutorialRepository tutorialRepository;

    public TutorialServiceImpl() {
        super();
    }

    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this();
        this.tutorialRepository = tutorialRepository;
    }

    //TODO
    @Override
    public List<TutorialDto> getAll() {
        List<TutorialDto> dtos = tutorialRepository.findAll().stream().map(entity -> new TutorialDto(
                entity.getN(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getSubmitted()
        )).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public TutorialDto getByN(Long n) throws Exception {
        Optional<TutorialEntity> optional = tutorialRepository.findById(n);
        TutorialEntity entity;
        if(optional.isPresent()) {
            entity=optional.get();
            log.info(entity.toString());
            return TutorialMapper.fromEntityToDto(entity);
        }
        throw new Exception(format("Tutorial with id=%s NOT FOUND", n));
    }

    @Override
    public List<TutorialDto> getByTitle(String title) {
        List<TutorialEntity> tutors = tutorialRepository.findByTitleOrderByNDesc(title);
        List<TutorialDto> dtos = TutorialMapper.fromListEntityToListDto(tutors);
        return dtos;
    }

    @Override
    public void deleteByN(Long n) throws Exception {
        TutorialEntity entity = tutorialRepository.getOne(n);
        if (entity != null) {
            tutorialRepository.deleteById(n);
        } else {
            throw new Exception(format("Tutorial with n=%s not found.", n));
        }
    }

    @Override
    public TutorialDto update(TutorialDto tutorialDto) throws Exception {
        if (tutorialDto == null) {
            throw new Exception("TutorialDto is null");
        }
        if (tutorialDto.getN() == null) {
            throw new Exception("N TutorialDto is null");
        }
        if (tutorialDto.getTitle() == null) {
            throw new Exception("Title TutorialDto is null");
        }
        if (tutorialDto.getDescription() == null) {
            throw new Exception("Description TutorialDto is null");
        }

        TutorialEntity entity = tutorialRepository.getOne(tutorialDto.getN());
        if (entity == null) {
            throw new Exception(format("Tutorial with n=%s not found.", tutorialDto.getN()));
        }
        entity.setTitle(tutorialDto.getTitle());
        entity.setDescription(tutorialDto.getDescription());
        entity.setSubmitted(tutorialDto.getSubmitted());
        tutorialRepository.saveAndFlush(entity);

        return TutorialMapper.fromEntityToDto(entity);
    }

}
