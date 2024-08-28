package com.Employee;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Externalclass {
        @Value("${employee.name}")
        private String name;

}
