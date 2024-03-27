package com.example.stackoverflow.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="questions")
public class Question {

    @Id
    @Column(name="question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "user_id")
    private User author;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name = "creation_date")
    private java.time.LocalDateTime creationDate;

    @Column(name="picture_url")
    private String pictureUrl;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "question_tags",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    public void addTag(Tag tag) {
        tags.add(tag);
    }

}
