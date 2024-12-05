package com.generator.exam.generator.interfaces;

import com.generator.exam.generator.question.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    Set<Question> getQuestions();
}