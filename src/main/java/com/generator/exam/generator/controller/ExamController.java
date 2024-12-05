package com.generator.exam.generator.controller;

import com.generator.exam.generator.interfaces.ExaminerService;
import com.generator.exam.generator.question.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get")
    public String getQuestions(@RequestParam("amount") int amount) {
        return examinerService.getQuestion(amount).toString();
    }

    @GetMapping(path = "/clear")
    public Collection<Question> clear() {
        return examinerService.clear();
    }
}