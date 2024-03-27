package com.example.stackoverflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vote_id")
    private Long voteId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="vote_type")
    private String voteType; // "UPVOTE" or "DOWNVOTE"

    @Column(name="content_type")
    private String contentType; // "QUESTION" or "ANSWER"

    @Column(name="content_id")
    private Long contentId;


}
