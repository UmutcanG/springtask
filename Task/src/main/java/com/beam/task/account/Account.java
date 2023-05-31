package com.beam.task.account;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.management.relation.Role;

@Data
@Document
@TypeAlias("Account")
public class Account {
    @Id
    private String id;
    private String name;
    private String password;
    private boolean admin;

}
