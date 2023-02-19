package com.easycar.backend.service;

import com.easycar.backend.model.User;
import com.easycar.backend.repository.UserRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    @Override
    public User get(ObjectNode node) {
        return userRepository.getUser(node.get("username").asText(), node.get("password").asText());
    }

}

