package com.example.Relationship20.Repository;

import com.example.Relationship20.Entity.UserOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOneRepository extends JpaRepository<UserOne, Long> {
}
