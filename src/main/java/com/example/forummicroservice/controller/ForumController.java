package com.example.forummicroservice.controller;

import com.example.forummicroservice.entites.Forum;
import com.example.forummicroservice.service.ForumInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/forums")
public class ForumController {

    private String title="hello , im the updated forum microservice";

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println(title);
        return title;
    }

    @Autowired
    private ForumInterface forumService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Forum> add(@RequestBody Forum forum) {
        return new ResponseEntity<>(forumService.createForum(forum), HttpStatus.OK);
    }
}
