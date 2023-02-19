package com.easycar.backend.service;

import com.easycar.backend.model.Image;

import java.util.List;

public interface ImageService {
    public List<Image> get(Integer vehicle);
}
