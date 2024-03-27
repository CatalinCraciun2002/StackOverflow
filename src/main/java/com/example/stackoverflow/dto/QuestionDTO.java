package com.example.stackoverflow.dto;

import com.example.stackoverflow.entity.Question;
import com.example.stackoverflow.entity.Tag;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {
    private String title;
    private String text;
    private Tag[] tags;
    private String pictureUrl;
    private Long authorId;

    public Question createQuestion() {
        Question question = new Question();
        question.setTitle(title);
        question.setText(text);
        question.setPictureUrl(pictureUrl);
        for (Tag tag : tags) {
            question.addTag(tag);
        }

        return question;
    }




}
