package ru.perm.v.tutorial.service.impl;

import org.junit.jupiter.api.Test;
import ru.perm.v.tutorial.dto.TutorialDto;
import ru.perm.v.tutorial.entity.TutorialEntity;
import ru.perm.v.tutorial.repository.TutorialRepository;
import ru.perm.v.tutorial.service.TutorialService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TutorialServiceImplTest {
    TutorialRepository tutorialRepository = mock(TutorialRepository.class);

    @Test
    void getAll() {
        TutorialDto dto1 = new TutorialDto(1L);
        TutorialDto dto2 = new TutorialDto(2L);

        TutorialEntity entity1 = new TutorialEntity(1L);
        TutorialEntity entity2 = new TutorialEntity(2L);
        when(tutorialRepository.findAll()).thenReturn(List.of(entity1, entity2));

        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);

        assertEquals(2, tutorialService.getAll().size());
    }

    @Test
    void getAll_asList() {

        TutorialEntity entity1 = new TutorialEntity(1L);
        TutorialEntity entity2 = new TutorialEntity(2L);
        when(tutorialRepository.findAll()).thenReturn(Arrays.asList(entity1, entity2));

        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);

        List<TutorialDto> tutors = tutorialService.getAll();
        assertEquals(2, tutors.size());

        TutorialDto dto1 = new TutorialDto(1L);
        TutorialDto dto2 = new TutorialDto(2L);
        assertEquals(dto1, tutors.get(0));
        assertEquals(dto2, tutors.get(1));
    }


    @Test
    public void getByN() {
        Long N = 1L;
        TutorialEntity entity1 = new TutorialEntity(N);
        when(tutorialRepository.getOne(N)).thenReturn(entity1);

        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);

        TutorialDto tutor = null;
        try {
            tutor = tutorialService.getByN(N);
        } catch (Exception e) {
            fail();
        }
        
        assertEquals(N, tutor.getN());
    }

    @Test
    public void notFoundGetByN() throws Exception {
        Long ID = 2L;
        when(tutorialRepository.getOne(ID)).thenReturn(null);
        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);
        TutorialDto dto = tutorialService.getByN(ID);
        assertNull(dto);
    }

    @Test
    void getByTitle() {
        String TITLE = "TITLE";
        List<TutorialEntity> entities= List.of(new TutorialEntity(1L), new TutorialEntity(2L));
        when(tutorialRepository.findByTitleOrderByNDesc(TITLE)).thenReturn(entities);
        TutorialService tutorialService = new TutorialServiceImpl(tutorialRepository);

        List<TutorialDto> dtos = tutorialService.getByTitle(TITLE);

        assertEquals(2, dtos.size());

        assertEquals(Long.valueOf(1), dtos.get(0).getN());
        assertEquals(Long.valueOf(2), dtos.get(1).getN());
    }

    @Test
    void deleteById() {
//        long ID = 2;
//        TutorialService companyService = new CompanyServiceImpl(companyRepository);
//        companyService.deleteById(ID);
//        verify(companyRepository, times(1)).deleteById(ID);
    }

    @Test
    void getByShortName() {
//        String SHORTNAME = "SHORTNAME";
//        ru.perm.v.companies.entity.TutorialEntity company1 = new ru.perm.v.companies.entity.TutorialEntity(1);
//        company1.setShortname(SHORTNAME);
//        ru.perm.v.companies.entity.TutorialEntity company2 = new ru.perm.v.companies.entity.TutorialEntity(2);
//        company2.setShortname(SHORTNAME);
//
//        TutorialService companyService = new CompanyServiceImpl(companyRepository);
//        when(companyRepository.findByShortnameOrderByNDesc(SHORTNAME))
//                .thenReturn(List.of(company1, company2));
//
//        List<TutorialDto> companies = companyService.getByShortName(SHORTNAME);
//
//        assertEquals(2, companies.size());
//        assertEquals(SHORTNAME, companies.get(0).getShortname());
//        assertEquals(SHORTNAME, companies.get(1).getShortname());
    }

    @Test
    void fromEntityToDto() {
//        ru.perm.v.companies.entity.TutorialEntity tutorialEntity = new ru.perm.v.companies.entity.TutorialEntity();
//        tutorialEntity.setN(100L);
//        tutorialEntity.setInn("1234");
//        tutorialEntity.setOgrn("OGRN");
//        tutorialEntity.setAddressUr("ADDRESS_UR");
//        tutorialEntity.setAddressPost("ADDRESS_POST");
//        tutorialEntity.setShortname("SHORTNAME");
//        EmployeeEntity DIRECTOR = new EmployeeEntity(10L);
//        tutorialEntity.setDirector(DIRECTOR);
//        tutorialEntity.setFullname("FULLNAME");
//
//        TutorialDto dto = ru.perm.v.companies.mappers.TutorialMapper.fromEntityToDto(tutorialEntity);
//        TutorialDto expected = new TutorialDto();
//        expected.setN(100L);
//        expected.setInn("1234");
//        expected.setOgrn("OGRN");
//        expected.setAddressUr("ADDRESS_UR");
//        expected.setAddressPost("ADDRESS_POST");
//        expected.setShortname("SHORTNAME");
//        expected.setFullname("FULLNAME");
//        EmployeeDto DIRECTOR_DTO = new EmployeeDto();
//        Long DIRECTOR_N = 200L;
//        DIRECTOR_DTO.setN(DIRECTOR_N);
//        expected.setDirector(DIRECTOR_DTO);
//
//        assertEquals(expected, dto);
    }
}
