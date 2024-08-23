package com.example.employeemanagementsystem.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class EmployeeSummary {
    private final String name;
    private final String email;
    private final String departmentName;
}
