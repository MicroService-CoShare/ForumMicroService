package com.example.forummicroservice.repositories;

import com.example.forummicroservice.entites.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepo extends JpaRepository<Forum,Integer> {
}
