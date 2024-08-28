package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {
    @JsonProperty()
    private String name;

    @JsonProperty()
    private String email;
}
