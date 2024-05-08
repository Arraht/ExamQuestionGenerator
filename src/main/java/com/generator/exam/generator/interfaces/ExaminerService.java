package com.generator.exam.generator.interfaces;

import com.generator.exam.generator.question.Question;

import java.util.Collection;
import java.util.Set;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);

    Collection<Question> clear();
}