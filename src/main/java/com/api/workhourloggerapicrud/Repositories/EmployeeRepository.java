package com.api.workhourloggerapicrud.Repositories;

import com.api.workhourloggerapicrud.Models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {

}
