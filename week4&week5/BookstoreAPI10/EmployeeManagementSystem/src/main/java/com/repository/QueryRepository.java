package com.repository;


import com.Employee.Employee;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QueryRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT u FROM Employee u WHERE CONCAT(u.name, ' ', u.id) LIKE %:keyword%")
    List<Employee> findUsersByFullNameKeyword(@Param("keyword") String keyword);
}



