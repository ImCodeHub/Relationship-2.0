package com.example.Relationship20.Controller;

import com.example.Relationship20.Model.StudentModel;
import com.example.Relationship20.Service.ServiceImpl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("student-registration")
    public ResponseEntity<String> studentRegistration(@RequestBody StudentModel studentModel){
        String response = studentService.saveStudent(studentModel);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
