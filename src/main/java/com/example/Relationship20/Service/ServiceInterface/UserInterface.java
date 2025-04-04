package com.example.Relationship20.Service.ServiceInterface;

import com.example.Relationship20.Entity.User;
import com.example.Relationship20.Model.UserProfileModel;
import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserInterface {
    public User saveUser(UserProfileModel userProfileModel, MultipartFile imageFile) throws IOException, MessagingException;
    public UserProfileModel getUserDetailsById(Long userId) throws IOException;
}
