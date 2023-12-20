package com.upload.image.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.upload.image.model.Image;
import com.upload.image.service.ImageService;


@RestController
@RequestMapping("/api")
public class ImageController {
	
	@Autowired
    private ImageService imageService;

	@PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        Image savedImage = imageService.saveImage(file);

        if (savedImage != null) {
            return ResponseEntity.ok("Image uploaded successfully. Image ID: " + savedImage.getId());
        } else {
            return ResponseEntity.badRequest().body("Failed to upload image.");
        }
    }
}
