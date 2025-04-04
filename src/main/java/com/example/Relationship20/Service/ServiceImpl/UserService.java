package com.example.Relationship20.Service.ServiceImpl;

import com.example.Relationship20.Entity.Post;
import com.example.Relationship20.Entity.Profile;
import com.example.Relationship20.Entity.User;
import com.example.Relationship20.Model.PostModel;
import com.example.Relationship20.Model.UserProfileModel;
import com.example.Relationship20.Repository.UserRepository;
import com.example.Relationship20.Service.ServiceInterface.UserInterface;
import com.example.Relationship20.Service.Utility.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserInterface {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public User saveUser(UserProfileModel userProfileModel, MultipartFile imageFile) throws IOException {

        // save the image in directory & return the unique file name
        String imageFileName = imageService.saveUserImage(imageFile);


        Profile profile = new Profile();
        profile.setCity(userProfileModel.getCity());
        profile.setState(userProfileModel.getState());
        profile.setAddress(userProfileModel.getAddress());
        profile.setAge(userProfileModel.getAge());
        profile.setMobile(userProfileModel.getMobile());
        profile.setGender(userProfileModel.getGender());
        profile.setDob(userProfileModel.getDob());
        profile.setImage(imageFileName);

        User user = new User();
        user.setFirstName(userProfileModel.getFirstName());
        user.setLastName(userProfileModel.getLastName());
        user.setEmail(userProfileModel.getEmail());
        user.setPassword(userProfileModel.getPassword());
        user.setProfile(profile);

        return userRepository.save(user);
    }

    @Override
    public UserProfileModel getUserDetailsById(Long userId) throws IOException {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found by this ID: " + userId));
        //get the image from image directory
        String image = imageService.getEncodedImageFromDirectory(user.getProfile().getImage());
        UserProfileModel userProfileModel = new UserProfileModel();
        userProfileModel.setFirstName(user.getFirstName() + " " + user.getLastName());
//        userProfileModel.setLastName(user.getLastName());
//        userProfileModel.setDob(user.getProfile().getDob());
//        userProfileModel.setCity(user.getProfile().getCity());
//        userProfileModel.setState(user.getProfile().getState());
//        userProfileModel.setAddress(user.getProfile().getAddress());
        userProfileModel.setAge(user.getProfile().getAge());
        userProfileModel.setEmail(user.getEmail());
        userProfileModel.setGender(user.getProfile().getGender());
        userProfileModel.setMobile(user.getProfile().getMobile());

        return userProfileModel;
    }

    public List<PostModel> getUserPost(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("uer not found"));
        List<Post> posts = user.getPosts();
        /**this is normal way*/
//        List<PostModel> postModelList = new ArrayList<>();
//        for (Post post : posts) {
//            PostModel postModel = new PostModel();
//            postModel.setTitle(post.getTitle());
//            postModel.setDescription(post.getDescription());
//            postModelList.add(postModel);
//        }
//        return postModelList;

        /**this is using stream api and lambda expression*/
        return posts.stream().map((x) -> {
            PostModel postModel = new PostModel();
            postModel.setTitle(x.getTitle());
            postModel.setDescription(x.getDescription());
            postModel.setDateTime(x.getDateTime());
            return postModel;
        }).collect(Collectors.toList());

    }


}
