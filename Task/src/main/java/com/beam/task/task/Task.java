package com.beam.task.task;

import com.beam.task.account.Account;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@TypeAlias("Task")
public class Task {
    @Id
    private String id;
    private String sender;
    private String comment;
    private String answer;
}
