package com.easycar.backend.service;

import com.easycar.backend.model.User;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface UserService {
    public User register(User user);
    public User get(ObjectNode node);
}
