package com.repository;


import com.Employee.Employee;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Employee, Long> {
    List<User> findByName(String name);
}

