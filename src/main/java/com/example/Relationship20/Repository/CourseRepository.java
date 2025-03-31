package com.example.Relationship20.Repository;

import com.example.Relationship20.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    //JPQL
    @Query("SELECT course FROM Course course WHERE course.id IN :ids")
    public Set<Course> findByAllIds(@Param("ids") Set<Long> ids);
}
