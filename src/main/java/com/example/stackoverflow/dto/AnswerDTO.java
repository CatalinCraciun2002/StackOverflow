package com.example.stackoverflow.dto;

import com.example.stackoverflow.entity.Answer;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerDTO {

    private Long questionId;
    private Long authorId;
    private String text;
    private String pictureUrl;

    public Answer createAnswer() {
        Answer answer = new Answer();
        answer.setText(text);
        answer.setPictureUrl(pictureUrl);
        return answer;
    }

}
