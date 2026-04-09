package test.employeeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.employeeManager.Entity.EmployeeManagerEntity;

@Repository
public interface EmployeeManagerRepository extends JpaRepository< EmployeeManagerEntity , Long > {
}
