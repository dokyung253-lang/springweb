package test.departmentManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.departmentManager.entity.DepartmentManagerEntity;

@Repository
public interface DepartmentManagerRepository extends JpaRepository< DepartmentManagerEntity , Long > {
}
