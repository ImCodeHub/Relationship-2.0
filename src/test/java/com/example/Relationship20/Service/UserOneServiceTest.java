package com.example.Relationship20.Service;


import com.example.Relationship20.Entity.UserOne;
import com.example.Relationship20.Repository.UserOneRepository;
import com.example.Relationship20.Service.UserOneTest.UserOneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserOneServiceTest {

    @Mock
    private UserOneRepository userOneRepository;

    @InjectMocks
    private UserOneService userOneService;

    UserOne userOne = new UserOne();

    @BeforeEach
    void setUp(){
        /**MockitoAnnotations.openMocks(this); > you can either user this line or you can use @ExtendWith(MockitoExtension.class) on top of the class*/
        userOne = UserOne.builder()
                .id(1L)
                .name("Superman")
                .age(50)
                .email("super@gmail.com").build();
    }

    @Test
    public void testSaveUser(){
        //mock userOneRepository and pretent to save any UserOne.class then return userOne
         when(userOneRepository.save(any(UserOne.class))).thenReturn(userOne);
        String response = userOneService.saveUser(userOne);
        assertThat(response).isEqualTo("user successfully Registered");
    }
    
    @Test
    public void testFindUserById(){
        Long userId = 1l;
        when(userOneRepository.findById(userId)).thenReturn(Optional.ofNullable(userOne));
        UserOne user = userOneService.findUserById(1L);
        assertThat(user.getId()).isEqualTo(userOne.getId());
        assertThat(user.getName()).isEqualTo(userOne.getName());
        assertThat(user.getAge()).isEqualTo(userOne.getAge());
        assertThat(user.getAge()).isEqualTo(userOne.getAge());
        assertThat(user.getEmail()).isEqualTo(userOne.getEmail());
    }


}
