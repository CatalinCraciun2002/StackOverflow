package com.example.stackoverflow.controller;

import com.example.stackoverflow.dto.QuestionDTO;
import com.example.stackoverflow.entity.Question;
import com.example.stackoverflow.entity.User;
import com.example.stackoverflow.service.QuestionService;
import com.example.stackoverflow.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Question> retrieveAllQuestions() {
        return this.questionService.retrieveQuestions();
    }

    @PostMapping("/insertQuestion")
    @ResponseBody
    public Question insertQuestion(@RequestBody QuestionDTO questionDTO) {
        Question question = new Question();
        question.setTitle(questionDTO.getTitle());
        question.setText(questionDTO.getText());
        return this.questionService.insertQuestion(question, questionDTO.getAuthorId());
    }


    @PutMapping("/updateQuestion")
    @ResponseBody
    public Question updateQuestion(@RequestBody QuestionDTO questionDTO) {
        Question question = new Question();
        question.setTitle(questionDTO.getTitle());
        question.setText(questionDTO.getText());
        return this.questionService.updateQuestion(question, questionDTO.getAuthorId());
    }

    @DeleteMapping("/deleteQuestion/{id}")
    @ResponseBody
    public String deleteById(@PathVariable Long id) {
        return this.questionService.deleteById(id);
    }
}
