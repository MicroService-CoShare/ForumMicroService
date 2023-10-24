package com.example.forummicroservice.service;

import com.example.forummicroservice.entites.Forum;

import java.util.List;

public interface ForumInterface {
    Forum createForum(Forum forum);
    Forum getForumById(int forumId);
    List<Forum> getAllForums();
    Forum updateForum(Forum forum);
    Boolean deleteForum(int forumId);
}
