package ru.perm.v.tutorial.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class TutorialDtoTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToString() {
        TutorialDto dto = new TutorialDto(1L,"TITLE", "DESCRIPTION", true);
        String s = dto.toString();

        assertEquals("TutorialDto{n=1, title='TITLE', description='DESCRIPTION', submitted=true}", s);
    }

//    @Test
//    void testToString() {
//        EmployeeDto employeeDto = new EmployeeDto();
//        CompanyDto companyDto = new CompanyDto(1L, "SHORTNAME", "FULLNAME", "INN", "OGRN","ADDRESS_POST","ADDRESS_UR", employeeDto);
//        String result = companyDto.toString();
//
//        assertEquals("CompanyDto{n=1, shortName='SHORTNAME', fullName='FULLNAME', inn='INN', ogrn='OGRN', addressPost='ADDRESS_POST', addressUr='ADDRESS_UR'}", result.toString());
//    }
//
//    @Test
//    void testEquals() {
//        EmployeeDto employeeDto = new EmployeeDto();
//        CompanyDto companyDto1 = new CompanyDto(1L, "SHORTNAME", "FULLNAME", "INN", "OGRN","ADDRESS_POST","ADDRESS_UR", employeeDto);
//        CompanyDto companyDto2 = new CompanyDto(1L, "SHORTNAME", "FULLNAME", "INN", "OGRN","ADDRESS_POST","ADDRESS_UR", employeeDto);
//
//        boolean result = companyDto1.equals(companyDto2);
//
//        assertTrue(result);
//    }
//
//    @Test
//    void testHashCode() {
//        CompanyDto companyDto = new CompanyDto();
//        int result = companyDto.hashCode();
//        assertNotEquals(0, result);
//    }
}

