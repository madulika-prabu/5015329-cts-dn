package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {
    @JsonProperty()
    private String title;

    @JsonProperty()
    private String author;
}
