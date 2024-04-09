package com.api.workhourloggerapicrud.Controller;


import com.api.workhourloggerapicrud.Dtos.EmployeeDto;
import com.api.workhourloggerapicrud.Models.EmployeeModel;
import com.api.workhourloggerapicrud.Services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController // Marks the class as a REST controller
@CrossOrigin(origins = "*", maxAge = 3600) // Enables Cross-Origin Resource Sharing (CORS)
@RequestMapping("/work-hour-logger-api") // Maps HTTP requests to a specific handler method

public class EmployeeController {
    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        var EmployeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeDto, EmployeeModel);
        EmployeeModel.setEntryTime((LocalDateTime.now(ZoneId.of("UTC"))));
        EmployeeModel.setExitTime((LocalDateTime.now(ZoneId.of("UTC"))));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(EmployeeModel));
    }

    @GetMapping()
    public ResponseEntity<Object> getEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEmployee(@PathVariable UUID id) {
        Optional<EmployeeModel> EmployeeModelOptional = employeeService.findEmployeeById(id);
        if (EmployeeModelOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employee Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeService.getEmployees());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable UUID id) {
        Optional<EmployeeModel> EmployeeModelOptional = employeeService.findEmployeeById(id);
        if (EmployeeModelOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employee Found");
        employeeService.DeleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted Successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable UUID id, EmployeeDto employeeDto) {
        Optional<EmployeeModel> EmployeeModelOptional = employeeService.findEmployeeById(id);
        if (EmployeeModelOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employee Found");
        var employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeModel, employeeModel);
        employeeModel.setId(EmployeeModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.saveEmployee(employeeModel));

    }
}
