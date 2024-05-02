package net.javaguides.emsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private EmployeeService employeeService;

    // build add employee rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // build get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //built get all employee rest api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        employeeService.getAllEmployees();
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    //built update all employee rest api
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //built delete all employee rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully !");
    }
}
