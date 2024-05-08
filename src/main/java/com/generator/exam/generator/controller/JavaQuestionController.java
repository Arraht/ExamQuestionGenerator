package com.generator.exam.generator.controller;

import com.generator.exam.generator.interfaces.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public String addQuestion(@RequestParam("question") String question,
                              @RequestParam("answer") String answer) {
        questionService.add(question, answer);
        return "Вопрос был добавлен";
    }

    @GetMapping(path = "/remove")
    public String removeQuestion(@RequestParam("question") String question,
                                 @RequestParam("answer") String answer) {
        questionService.remove(question, answer);
        return "Вопрос был удалён";
    }

    @GetMapping(path = "/find")
    public String getQuestions() {
        return questionService.getAll().toString();
    }
}