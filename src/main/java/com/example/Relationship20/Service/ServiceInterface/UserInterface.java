package com.example.Relationship20.Service.ServiceInterface;

import com.example.Relationship20.Entity.User;
import com.example.Relationship20.Model.UserProfileModel;

public interface UserInterface {
    public User saveUser(UserProfileModel userProfileModel);
    public UserProfileModel getUserDetailsById(Long userId);
}
