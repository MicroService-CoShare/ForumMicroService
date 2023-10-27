package com.example.forummicroservice.service;

import com.example.forummicroservice.entites.Forum;
import com.example.forummicroservice.repositories.ForumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumImp implements ForumInterface {
    @Autowired
    private ForumRepo forumRepository;

    @Override
    public Forum createForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public Optional<Forum> getForumById(int forumId) {
        return forumRepository.findById(forumId);
    }

    @Override
    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    @Override
    public Forum updateForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public Boolean deleteForum(int forumId) {
        if (forumRepository.existsById(forumId)) {
            forumRepository.deleteById(forumId);
            return true;
        } else {
            return false;
        }
    }


}
