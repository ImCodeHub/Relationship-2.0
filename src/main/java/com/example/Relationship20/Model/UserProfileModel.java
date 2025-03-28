package com.example.Relationship20.Model;

import com.example.Relationship20.Entity.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // what ever the null value will include
public class UserProfileModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String city;
    private String state;
    private String address;
    private String mobile;
    private int age;
    private Gender gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dob;
}
