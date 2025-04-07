package com.example.Relationship20.Controller;

import com.example.Relationship20.Entity.UserOne;
import com.example.Relationship20.Service.UserOneTest.UserOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userOne/testing")
public class UserOneController {
    @Autowired
    private UserOneService userOneService;

    @PostMapping("user-register")
    public ResponseEntity<String> userResitration(@RequestBody UserOne userOne){
        String response = userOneService.saveUser(userOne);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("find-user/{id}")
    public ResponseEntity<UserOne> findUserBySpecificId(@PathVariable Long id){
        UserOne user = userOneService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
}
