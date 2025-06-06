package com.example.Relationship20.Service.Utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

@Service
public class ImageService {
    @Value("${file.user-directory}")
    private String uploadDirectory;  //uploadDirectory = src/main/resources/user-images

    public String saveUserImage(MultipartFile imageFile) throws IOException {
        if(imageFile.isEmpty()){
            throw new IOException("Empty file can not save.");
        }
        //create file name
        String imageFileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();//4654649465_abcd.jpeg

        Path directoryPath = Paths.get(uploadDirectory,imageFileName);
        // it will ensure that directory exists or not
        Files.createDirectories(directoryPath.getParent());
        //save image
        Files.copy(imageFile.getInputStream(),directoryPath, StandardCopyOption.REPLACE_EXISTING);

        //return the image name
        return imageFileName;

    }

    public String getEncodedImageFromDirectory(String imageName ) throws IOException {
        //Step 1: find the path to image directory
        Path directoryPath = Paths.get(uploadDirectory).resolve(imageName);
        //Step 2: convert image into bytes
        byte[] imageBytes = Files.readAllBytes(directoryPath);
        //Step 3: convert image bytes in to String
        String stringFormatImage = Base64.getEncoder().encodeToString(imageBytes);
        //Step 4: return.
        return stringFormatImage;
    }


}
