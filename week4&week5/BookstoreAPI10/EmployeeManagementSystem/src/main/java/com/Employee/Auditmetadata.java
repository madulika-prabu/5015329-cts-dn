package com.Employee;

import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

public class Auditmetadata {

    @CreatedBy
    private User user;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedBy
    private User lastModifiedBy;

    @LastModifiedDate
    private Instant lastModifiedDate;
}
