package com.easycar.backend.service;

import com.easycar.backend.model.Image;
import com.easycar.backend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageImpl implements ImageService{
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> get(Integer vehicle) {
        return imageRepository.get(vehicle);
    }
}
