package com.example.Relationship20.Repository;

import com.example.Relationship20.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
