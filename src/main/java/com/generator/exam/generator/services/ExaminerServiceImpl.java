package com.generator.exam.generator.services;

import com.generator.exam.generator.exceptions.BadAmountException;
import com.generator.exam.generator.exceptions.EmptyListException;
import com.generator.exam.generator.interfaces.ExaminerService;
import com.generator.exam.generator.interfaces.QuestionService;
import com.generator.exam.generator.question.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    private final Set<Question> questionSet = new HashSet<>(Set.of());

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (questionService.getAll().isEmpty()) {
            throw new EmptyListException("List is empty");
        } else if (amount <= 0) {
            throw new BadAmountException("Bad amount");
        } else if (questionService.getAll().size() < amount) {
            throw new BadAmountException("Запрошено вопросов больше чем есть вопросов");
        } else {
            while (questionSet.size() < amount) {
                questionSet.add(questionService.getRandomQuestion());
            }
            return questionSet;
        }
    }

    @Override
    public Collection<Question> clear() {
        questionSet.clear();
        return questionSet;
    }
}