package test.employeeManager.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.employeeManager.repository.EmployeeManagerRepository;

@Service @RequiredArgsConstructor @Transactional
public class EmployeeManagerService {
    private final EmployeeManagerRepository employeeManagerRepository;
}
