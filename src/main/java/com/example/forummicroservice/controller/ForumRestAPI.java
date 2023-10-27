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

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed("user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Forum> addForum(@RequestBody Forum forum) {
        return new ResponseEntity<>(forumService.addForum(forum), HttpStatus.OK);
    }

    @RolesAllowed("user")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Forum> updateForum(@PathVariable(value = "id") int id,
                                             @RequestBody Forum forum) {
        return new ResponseEntity<>(forumService.updateForum(id, forum), HttpStatus.OK);
    }

    @RolesAllowed("user")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteForum(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(forumService.deleteForum(id), HttpStatus.OK);
    }

    @RequestMapping("/getAll")
    @RolesAllowed("user")
    public ResponseEntity<List<Forum>> getAllForums() {
        List<Forum> forums = forumService.getAllForums();
        return new ResponseEntity<>(forums, HttpStatus.OK);
    }
}
