package com.example.forummicroservice.service;

import com.example.forummicroservice.entites.Forum;

import java.util.List;
import java.util.Optional;

public interface ForumInterface {
    Forum addForum(Forum forum);
    Forum getForumById(int forumId);
    List<Forum> getAllForums();
    Forum updateForum(int id, Forum newForum);
    String deleteForum(int forumId);
}
