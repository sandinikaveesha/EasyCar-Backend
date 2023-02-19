package com.easycar.backend.controller;

import com.easycar.backend.model.Comment;
import com.easycar.backend.service.CommentService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add_comment")
    public String addComment(@RequestBody ObjectNode node){return commentService.commentDetails(node);}

    @GetMapping("/all_comments")
    public List<Comment> allComments(){return commentService.allComments();}
}
