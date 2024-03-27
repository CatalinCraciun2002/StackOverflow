package com.example.stackoverflow.controller;

import com.example.stackoverflow.dto.AnswerDTO;
import com.example.stackoverflow.entity.Answer;
import com.example.stackoverflow.entity.Question;
import com.example.stackoverflow.entity.User;
import com.example.stackoverflow.repository.QuestionRepository;
import com.example.stackoverflow.repository.UserRepository;
import com.example.stackoverflow.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Answer> retrieveAllAnswers() {
        return this.answerService.retrieveAnswers();
    }

    @PostMapping("/insertAnswer")
    @ResponseBody
    public Answer insertAnswer(@RequestBody AnswerDTO answerDTO) {

        return answerService.insertAnswer(answerDTO.createAnswer(), answerDTO.getAuthorId(), answerDTO.getQuestionId());
    }

    @PutMapping("/updateAnswer")
    @ResponseBody
    public Answer updateAnswer(@RequestBody AnswerDTO answerDTO) {

        return this.answerService.updateAnswer(answerDTO.createAnswer(), answerDTO.getAuthorId(),
                answerDTO.getQuestionId());
    }

    @DeleteMapping("/deleteAnswer/{id}")
    @ResponseBody
    public String deleteById(@PathVariable Long id) {
        return this.answerService.deleteById(id);
    }
}
