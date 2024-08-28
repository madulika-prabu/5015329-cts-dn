package com.repository;

import com.Employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface PagingRepository extends PagingAndSortingRepository<Employee, String> {

    List<Employee> findAll(String name, Pageable pageable);

    PageRequest sortedByName = PageRequest.of(0, 3, Sort.by("name"));

}


