package com.example.Relationship20.Service.UserOneTest;

import com.example.Relationship20.Entity.UserOne;
import com.example.Relationship20.Repository.UserOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserOneService {
    @Autowired
    private UserOneRepository userOneRepository;

    public String saveUser(UserOne userOne){
        UserOne save = userOneRepository.save(userOne);
        return "user successfully Registered";
    }

    public UserOne findUserById(Long userId){
        Optional<UserOne> optionalUser = userOneRepository.findById(userId);
        if(optionalUser.isPresent()){
            UserOne user = optionalUser.get();
            return user;
        }else{
            throw new RuntimeException("user not found by this id: "+userId);
        }
    }
}
