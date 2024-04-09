package com.api.workhourloggerapicrud.Services;

import com.api.workhourloggerapicrud.Models.EmployeeModel;
import com.api.workhourloggerapicrud.Repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public EmployeeModel saveEmployee(EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    public Object getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeModel> findEmployeeById(UUID id) {
        return employeeRepository.findById(id);
    }

    public void DeleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}
