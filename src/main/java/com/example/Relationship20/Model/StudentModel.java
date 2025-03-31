package com.example.Relationship20.Model;

import lombok.Data;

import java.util.Set;

@Data
public class StudentModel {
    private String name;
    private String email;
    private Set<Long> courserId;// ids of courses that Student wants to enroll. [3,2]
}
