package com.example.Relationship20.Model;

import com.example.Relationship20.Entity.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // what ever the null value will include
public class UserProfileModel {
    @NotNull(message = "user first name can not be null")
    private String firstName;
    @NotNull(message = "user last name can not be null")
    private String lastName;
    @Email(message = "add valid email format")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@gmail.com$",message = "Only gmail address are allowed")
    private String email;
    @NotBlank(message = "field can not blank")
    @Size(min = 8, max = 15, message = "password must be at least 8 character and maximum 15 character")
    private String password;

    private String image;


    private String city;
    private String state;
    private String address;
    private String mobile;
    @Min(value = 18,message = "your age must be 18 or above")
    private int age;
    private Gender gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dob;
}
