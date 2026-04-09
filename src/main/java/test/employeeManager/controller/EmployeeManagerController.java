package test.employeeManager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.employeeManager.service.EmployeeManagerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@CrossOrigin( value = "http://localhost:5173", exposedHeaders = "Authorization")
public class EmployeeManagerController {
    private final EmployeeManagerService employeeManagerService;
}
