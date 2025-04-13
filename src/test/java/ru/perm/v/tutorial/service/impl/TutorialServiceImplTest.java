package ru.perm.v.tutorial.service.impl;

import org.junit.jupiter.api.Test;
import ru.perm.v.tutorial.repository.TutorialRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TutorialServiceImplTest {
    TutorialRepository tutorialRepository = mock(TutorialRepository.class);

    @Test
    public void getAll() {
//        ru.perm.v.companies.entity.TutorialEntity company1 = new ru.perm.v.companies.entity.TutorialEntity(1);
//        ru.perm.v.companies.entity.TutorialEntity company2 = new ru.perm.v.companies.entity.TutorialEntity(2);
//        when(companyRepository.findAll()).thenReturn(List.of(company1, company2));
//        TutorialService companyService = new CompanyServiceImpl(companyRepository);
//
//        assertEquals(2, companyService.getAll().size());
    }

    @Test
    public void getAll_asList() {
//        ru.perm.v.companies.entity.TutorialEntity company1 = new ru.perm.v.companies.entity.TutorialEntity(1);
//        ru.perm.v.companies.entity.TutorialEntity company2 = new ru.perm.v.companies.entity.TutorialEntity(2);
//        when(companyRepository.findAll()).thenReturn(Arrays.asList(company1, company2));
//        TutorialService companyService = new CompanyServiceImpl(companyRepository);
//
//        assertEquals(2, companyService.getAll().size());
    }


    @Test
    public void getByN() {
//        long ID = 2;
//        ru.perm.v.companies.entity.TutorialEntity COMPANY = new ru.perm.v.companies.entity.TutorialEntity(ID);
//        when(companyRepository.findById(ID)).thenReturn(java.util.Optional.of(COMPANY));
//        TutorialService companyService = new CompanyServiceImpl(companyRepository);
//        try {
//            assertEquals(new TutorialDto(2L), companyService.getByN(ID));
//        } catch (Exception e) {
//            fail();
//        }
    }

    @Test
    public void notFoundGetByN() {
//        long ID = 2;
//        when(companyRepository.findById(ID)).thenReturn(Optional.empty());
//        TutorialService companyService = new CompanyServiceImpl(companyRepository);
//        boolean OK = false;
//        String errorMessage = "";
//        try {
//            companyService.getByN(ID);
//        } catch (Exception e) {
//            OK = true;
//            errorMessage = e.getMessage();
//        }
//        assertTrue(OK);
//        assertEquals("Company with id=2 NOT FOUND", errorMessage);
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
