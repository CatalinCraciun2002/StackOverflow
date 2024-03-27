package com.example.stackoverflow.service;

import com.example.stackoverflow.entity.Answer;
import com.example.stackoverflow.entity.Question;
import com.example.stackoverflow.entity.User;
import com.example.stackoverflow.repository.AnswerRepository;
import com.example.stackoverflow.repository.QuestionRepository;
import com.example.stackoverflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Answer> retrieveAnswers() {
        return (List<Answer>) this.answerRepository.findAll();
    }

    Answer retrieveAnswerAuthorAndQuestion(Answer currentAnswer, Long user_id, Long question_id) {
        User user = userRepository.findById(user_id).orElseThrow(()->
                new RuntimeException("User not found"));

        Question question = questionRepository.findById(question_id).orElseThrow(()->
                new RuntimeException("Question not found"));

        currentAnswer.setAuthor(user);
        currentAnswer.setQuestion(question);

        return currentAnswer;
    }

    public Answer insertAnswer(Answer answer, Long user_id, Long question_id) {

        answer = retrieveAnswerAuthorAndQuestion(answer, user_id, question_id);

        return this.answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer, Long user_id, Long question_id) {

        answer = retrieveAnswerAuthorAndQuestion(answer, user_id, question_id);

        return this.answerRepository.save(answer);
    }

    public String deleteById(Long id) {
        try {
            this.answerRepository.deleteById(id);
            return "Answer deleted successfully.";
        } catch (Exception e) {
            return "Failed to delete answer with id " + id;
        }
    }
}
