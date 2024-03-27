package com.example.stackoverflow.service;

import com.example.stackoverflow.entity.Question;
import com.example.stackoverflow.entity.User;
import com.example.stackoverflow.repository.QuestionRepository;
import com.example.stackoverflow.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Question> retrieveQuestions() {
        return (List<Question>) this.questionRepository.findAll();
    }

    public Question insertQuestion(Question question, Long user_id) {
        User user = userRepository.findById(user_id).orElseThrow(()-> new EntityNotFoundException("User not found"));
        question.setAuthor(user);
        return this.questionRepository.save(question);
    }

    public Question updateQuestion(Question question, Long user_id) {
        User user = userRepository.findById(user_id).orElseThrow(()-> new EntityNotFoundException("User not found"));
        question.setAuthor(user);
        return this.questionRepository.save(question);
    }

    public String deleteById(Long id) {
        try {
            this.questionRepository.deleteById(id);
            return "Question deleted successfully.";
        } catch (Exception e) {
            return "Failed to delete question with id " + id;
        }
    }
}
