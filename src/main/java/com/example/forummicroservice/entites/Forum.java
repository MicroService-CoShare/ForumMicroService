package com.example.forummicroservice.entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Forum implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int forumId;
    @Enumerated(EnumType.STRING)
    private ForumType type;
    private String title;
    @ElementCollection
    private List<String> questions;
}
