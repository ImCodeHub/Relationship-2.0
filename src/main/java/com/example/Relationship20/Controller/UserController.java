package com.example.Relationship20.Controller;

import com.example.Relationship20.Entity.User;
import com.example.Relationship20.Model.PostModel;
import com.example.Relationship20.Model.UserProfileModel;
import com.example.Relationship20.Service.ServiceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("user-registration")
    public ResponseEntity<User> userRegistration(@RequestBody UserProfileModel userProfileModel){
        User user = userService.saveUser(userProfileModel);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("get-user/{id}")
    public ResponseEntity<UserProfileModel> getUserById(@PathVariable Long id){
        UserProfileModel user = userService.getUserDetailsById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping("get-user-posts/{id}")
    public ResponseEntity<List<PostModel>> getAllPostOfUser(@PathVariable Long id){
        List<PostModel> userPost = userService.getUserPost(id);
        return new ResponseEntity<>(userPost, HttpStatus.FOUND);
    }

}
