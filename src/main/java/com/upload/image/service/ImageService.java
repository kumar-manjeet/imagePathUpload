package com.upload.image.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.upload.image.model.Image;
import com.upload.image.repository.ImageRepository;


@Service
public class ImageService {
	
	 @Autowired
	    private ImageRepository imageRepository;

	 public Image saveImage(MultipartFile file) {
	        try {
	            // Specify the directory where you want to save the uploaded files
	            String uploadDirectory = "/Users/manjeetyadav/Downloads/";

	            // Get the original filename
	            String fileName = file.getOriginalFilename();

	            // Save the file to the specified directory
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(uploadDirectory + fileName);
	            Files.write(path, bytes);

	            // Save the path in the database
	            Image imageEntity = new Image();
	            imageEntity.setImagePath(path.toString());
	            return imageRepository.save(imageEntity);
	        } catch (Exception e) {
	            // Handle exceptions (e.g., file not found, database error)
	            e.printStackTrace();
	            return null;
	        }
	    }
}
