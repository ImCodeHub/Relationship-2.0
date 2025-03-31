package com.example.Relationship20.Service.ServiceImpl;

import com.example.Relationship20.Entity.Course;
import com.example.Relationship20.Entity.Student;
import com.example.Relationship20.Model.StudentModel;
import com.example.Relationship20.Repository.CourseRepository;
import com.example.Relationship20.Repository.StudentRespository;
import com.example.Relationship20.Service.ServiceInterface.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService implements StudentInterface {
    @Autowired
    private StudentRespository studentRespository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String saveStudent(StudentModel studentModel) {
        Set<Course> courses = courseRepository.findByAllIds(studentModel.getCourserId());
        Student student = Student.builder()
                .name(studentModel.getName())
                .email(studentModel.getEmail())
                .courses(courses)
                .build();

            for(Course course : courses){
                course.getStudents().add(student);
            }

                studentRespository.save(student);
        return "Student has successfully registered and Enrolled the desire courses!";
    }
}
