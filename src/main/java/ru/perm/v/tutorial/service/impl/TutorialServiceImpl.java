package ru.perm.v.tutorial.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.repository.TutorialRepository;
import ru.perm.v.tutorial.service.TutorialService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<TutorialDto> tutors = new ArrayList<>();
        List<TutorialDto> dtos = tutorialRepository.findAll().stream().map(entity -> new TutorialDto(
                entity.getN(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getPublished(),
                entity.getSubmitted()
        )).collect(Collectors.toList());
        return dtos;
    }

    //TODO
    @Override
    public TutorialDto getByN(Long n) throws Exception {
        return null;
    }

    //TODO
    @Override
    public List<TutorialDto> getByTitle(String name) {
        return null;
    }

    //TODO
    @Override
    public void deleteById(Long id) {

    }

    //TODO
    @Override
    public TutorialDto update(TutorialDto tutorialDto) throws Exception {
        return null;
    }

//    @Override
//    public List<TutorialDto> getAll() {
//        List<CompanyEntity> companies = new ArrayList<>();
//        companyRepository.findAll().forEach(companies::add);
//        List<TutorialDto> dtos = companies.stream().map(entity -> new TutorialDto(
//                entity.getN(),
//                entity.getShortname(),
//                entity.getFullname(),
//                entity.getInn(),
//                entity.getOgrn(),
//                entity.getAddressPost(),
//                entity.getAddressUr(),
//                EmployeeMapper.fromEntityToDto(entity.getDirector())
//        )).collect(Collectors.toList());
//        return dtos;
//    }

//    @Override
//    public TutorialDto getByN(Long id) throws Exception {
//        CompanyEntity companyEntity = getEntityById(id);
//        return CompanyMapper.fromEntityToDto(companyEntity);
//    }

//    protected CompanyEntity getEntityById(Long id) throws Exception {
//        Optional<CompanyEntity> res = companyRepository.findById(id);
//        if (res.isPresent()) {
//            CompanyEntity companyEntity = res.get();
//            return companyEntity;
//        } else {
//            throw new Exception(String.format("Company with id=%s NOT FOUND", id));
//        }
//        // или ВЫЗВАТЬ метод (orElseGet)
//        // return res.orElseGet(this::getNotFonded);
//    }

//    @Override
//    public List<TutorialDto> getByShortName(String name) {
//        List<CompanyEntity> companies = companyRepository.findByShortnameOrderByNDesc(name);
//        List<TutorialDto> dtos = companies.stream().map(CompanyMapper::fromEntityToDto).collect(Collectors.toList());
//        return dtos;
//TODO: release on Q
//        QCompanyEntity qCompany = QCompanyEntity.companyEntity;
//        List<BooleanExpression> predicates = new ArrayList<>();
//        if (!name.isEmpty()) {
//            predicates.add(qCompany.shortname.containsIgnoreCase(name));
//        }
//        BooleanExpression expression = predicates.stream().reduce((predicate, accum) -> accum.and(predicate)).orElse(null);
//        ArrayList<CompanyEntity> companies = new ArrayList<CompanyEntity>();
//        companyRepository.findAll(expression).forEach(companies::add);
//        List<CompanyDto> dtos = companies.stream().map(CompanyServiceImpl::fromEntityToDto)
//                .collect(Collectors.toList());
//        return dtos;
//    }

//    @Override
//    public void deleteById(Long id) {
//        companyRepository.deleteById(id);
//    }
//
//    @Override
//    public TutorialDto update(TutorialDto companyDto) throws Exception {
//        if (companyDto.getN() == null) {
//            throw new Exception(String.format("Company id is NULL"));
//        }
//        CompanyEntity companyEntity = CompanyMapper.fromDtoToEntity(companyDto);
//        CompanyEntity saved = companyRepository.save(companyEntity);
//
//        return CompanyMapper.fromEntityToDto(saved);
//    }


// Разные способы получения результата отбора
//    @Override
//    public List<CompanyEntity> getByShortName(String name) {
//        QCompanyEntity company = QCompanyEntity.companyEntity;
//        Predicate predicate = company.shortname.eq(name);
//        Iterable<CompanyEntity> companies = companyRepository.findAll(predicate);
//        ArrayList<CompanyEntity> ret = new ArrayList<>();
//        for(CompanyEntity c : companies) {
//            ret.add(c);
//        }
//
////        List<Long> ids = new ArrayList<>();
////        companies.forEach(companyEntity -> ids.add(companyEntity.getN()));
//
////      Другой способ маппинга по итератору
////        List<Long> ids = StreamSupport.stream(companies.spliterator(), false)
////                .map(CompanyEntity::getN)
////                .collect(Collectors.toList());
//        return ret;
//    }

}
