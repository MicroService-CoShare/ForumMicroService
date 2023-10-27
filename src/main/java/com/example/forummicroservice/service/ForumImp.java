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

    public Forum addForum(Forum forum) {
        return forumRepository.save(forum);
    }

    public Forum updateForum(int id, Forum newForum) {
        if (forumRepository.findById(id).isPresent()) {
            Forum existingForum = forumRepository.findById(id).get();
            existingForum.setTitle(newForum.getTitle());
            existingForum.setQuestions(newForum.getQuestions());
            return forumRepository.save(existingForum);
        } else {
            return null;
        }
    }

    public String deleteForum(int id) {
        if (forumRepository.findById(id).isPresent()) {
            forumRepository.deleteById(id);
            return "Forum deleted";
        } else {
            return "Forum not deleted";
        }
    }

    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }


    public Forum getForumById(int id) {
        return forumRepository.findById(id).orElse(null);
    }
}
