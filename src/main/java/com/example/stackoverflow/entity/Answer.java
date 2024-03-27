package com.example.stackoverflow.entity;

import com.example.stackoverflow.repository.QuestionRepository;
import com.example.stackoverflow.repository.UserRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="answer_id")
    private Long answerId;

    @ManyToOne
    @JoinColumn(name="question_id", referencedColumnName = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "user_id")
    private User author;

    @Column(name="text")
    private String text;

    @Column(name="creation_date")
    private java.time.LocalDateTime creationDate;

    @Column(name="picture_url")
    private String pictureUrl;

}
