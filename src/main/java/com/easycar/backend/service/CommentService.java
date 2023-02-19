package com.easycar.backend.service;

import com.easycar.backend.model.Comment;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface CommentService {
    public String commentDetails(ObjectNode node);
    public List<Comment> allComments();
}
