package com.example.Relationship20.Service.ServiceImpl;

import com.example.Relationship20.Entity.Post;
import com.example.Relationship20.Entity.User;
import com.example.Relationship20.Model.PostModel;
import com.example.Relationship20.Repository.PostRepository;
import com.example.Relationship20.Repository.UserRepository;
import com.example.Relationship20.Service.ServiceInterface.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostServiceInterface {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createPostInDb(PostModel postModel) {
//        check wether user id present in database or not?
        User user = userRepository.findById(postModel.getUserId()).orElseThrow(() -> new RuntimeException("user not found"));

/** this is normal way to se the object in Entity form dto*/

//        Post post = new Post();
//        post.setTitle(postModel.getTitle());
//        post.setDescription(postModel.getDescription());
        /** this is using Lombok Builder*/

        Post post = Post.builder()
                .title(postModel.getTitle())
                .description(postModel.getDescription())
                .user(user)
                .build();
        postRepository.save(post);
        return "your post successfully sent!";
    }


}
