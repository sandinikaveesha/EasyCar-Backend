package com.easycar.backend.controller;

import com.easycar.backend.model.Image;
import com.easycar.backend.service.ImageService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/get")
    public List<Image> get(@RequestBody ObjectNode data){
        return imageService.get(data.get("vehicle").asInt());
    }
}
