package com.example.forummicroservice.service;

import com.example.forummicroservice.entites.Forum;

import java.util.List;
import java.util.Optional;

public interface ForumInterface {
    Forum createForum(Forum forum);
    Optional<Forum> getForumById(int forumId);
    List<Forum> getAllForums();
    Forum updateForum(Forum forum);
    Boolean deleteForum(int forumId);
}
