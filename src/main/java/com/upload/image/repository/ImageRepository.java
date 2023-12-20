package com.upload.image.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upload.image.model.Image;


public interface ImageRepository extends JpaRepository<Image, Long> {

}
