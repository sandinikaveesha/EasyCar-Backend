package com.easycar.backend.service;

import com.easycar.backend.model.Comment;
import com.easycar.backend.repository.CommentRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    public String commentDetails(ObjectNode node){
        Comment newComment = new Comment();
        newComment.setComment(node.get("comment").asText());
        newComment.setRating(node.get("rating").asDouble());
        newComment.setTimeStamp(node.get("time_stamp").asText());
        newComment.setVehicleRef(node.get("vehicle_ref").asInt());
        newComment.setCustomerRef(node.get("customer_ref").asInt());
        commentRepository.save(newComment);
        return "Comment Added Successfully";
    }

    public List<Comment> allComments(){
        return commentRepository.findAll();
    }
}
