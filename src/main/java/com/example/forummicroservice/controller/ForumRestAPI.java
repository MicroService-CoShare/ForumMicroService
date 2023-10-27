package com.example.forummicroservice.controller;

import com.example.forummicroservice.entites.Forum;
import com.example.forummicroservice.service.ForumInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequestMapping("/api/forums")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE ,RequestMethod.OPTIONS})
@RestController
public class ForumRestAPI {

    private String admin="hello , im admin";

    @RequestMapping("/hello")
    @RolesAllowed("user")
    public String sayHello(){
        System.out.println("title");
        return "title";
    }
    @RequestMapping("/admin")
    @RolesAllowed("admin")
    public String sayAdmin(){
        System.out.println(admin);
        return admin;
    }

    @Autowired
    private ForumInterface forumService;

    @GetMapping
    public ResponseEntity<List<Forum>> getAllForums() {
        return new ResponseEntity<>(forumService.getAllForums(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Forum> getForumById(@PathVariable int id) {
        return forumService.getForumById(id)
                .map(forum -> new ResponseEntity<>(forum, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Forum> createForum(@RequestBody Forum forum) {
        return new ResponseEntity<>(forumService.createForum(forum), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Forum> updateForum(@RequestBody Forum forum) {
        return new ResponseEntity<>(forumService.updateForum(forum), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForum(@PathVariable int id) {
        forumService.deleteForum(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
