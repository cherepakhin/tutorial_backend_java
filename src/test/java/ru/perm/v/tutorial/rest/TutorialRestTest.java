package ru.perm.v.tutorial.rest;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TutorialRestTest {

//    EmployeeService employeeService = mock(EmployeeService.class);

//    @Test
//    public void getAll() {
//        EmployeeDto employee1 = new EmployeeDto();
//        employee1.setN(1L);
//        employee1.setFirstname("FIRST_NAME_1");
//        employee1.setLastname("LAST_NAME_1");
//        employee1.setFathername("FATHER_NAME_1");
//        employee1.setBirthday("2021/01/01");
//        EmployeeDto employee2 = new EmployeeDto();
//        employee2.setN(2L);
//        employee2.setLastname("LAST_NAME_2");
//        employee2.setFirstname("FIRST_NAME_2");
//        employee2.setFathername("FATHER_NAME_2");
//        employee2.setBirthday("2022/12/02");
//
//        when(employeeService.getAll()).thenReturn(List.of(employee1, employee2));
//
//        EmployeeRest employeeRest = new EmployeeRest(employeeService);
//        List<EmployeeDto> receivedEmpls = employeeRest.getAll().getBody();
//
//        assertEquals(2, receivedEmpls.size());
//        assertEquals(
//                new EmployeeDto(1L, "FIRST_NAME_1", "LAST_NAME_1", "FATHER_NAME_1", "2021/01/01"),
//                receivedEmpls.get(0));
//        assertEquals(
//                new EmployeeDto(2L, "FIRST_NAME_2", "LAST_NAME_2", "FATHER_NAME_2", "2022/12/02"),
//                receivedEmpls.get(1));
//    }
//
//    @Test
//    public void updateBadEmployee() {
//        EmployeeDto employee1 = new EmployeeDto();
//        employee1.setN(1L);
//        employee1.setFirstname(""); // empty!
//        employee1.setLastname("LAST_NAME_1");
//        employee1.setFathername("FATHER_NAME_1");
//        employee1.setBirthday("2021/01/01");
//
//        EmployeeRest employeeRest = new EmployeeRest(employeeService);
//        ResponseEntity response = employeeRest.update(employee1);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        ApiError apiError = (ApiError) response.getBody();
//        assertEquals(HttpStatus.BAD_REQUEST, apiError.getStatus());
//        assertEquals(1, apiError.getErrors().size());
//        assertEquals("field: firstname, error: Firstname empty", apiError.getErrors().get(0));
//    }
//
//    @Test
//    void getById() throws Exception {
//        Long ID = 100L;
//
//        EmployeeRest rest = new EmployeeRest(employeeService);
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setN(ID);
//        when(employeeService.getByN(ID)).thenReturn(employeeDto);
//
//        ResponseEntity<EmployeeDto> responseEmployee = rest.getById(ID);
//
//        assertEquals(new ResponseEntity<>(employeeDto, HttpStatus.OK), responseEmployee);
//        assertEquals(HttpStatus.OK, responseEmployee.getStatusCode());
//        assertEquals(employeeDto, responseEmployee.getBody());
//    }
//
//    @Test
//    public void exceptionOnNotFoundGetById() throws Exception {
//        Long ID = 100L;
//        EmployeeRest rest = new EmployeeRest(employeeService);
//
//        when(employeeService.getByN(ID)).thenThrow(new Exception(("NOT FOUND")));
//
//        ResponseEntity response = rest.getById(ID);
//        assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
//        assertEquals("Employee not found id=100", response.getBody());
//    }

}