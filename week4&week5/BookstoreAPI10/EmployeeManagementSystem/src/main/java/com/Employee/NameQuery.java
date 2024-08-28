package com.Employee;


import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@NamedQueries(
        {
                @NamedQuery(
                        name = "Employee.findAllOrderByNameDesc",
                        query = "SELECT p from Employee p ORDER By p.name DESC"
                ),
                @NamedQuery(
                        name = "Product.findByPrice",
                        query = "SELECT p from Employee p where p.id = id"
                )
        }
)

public class NameQuery {
}
