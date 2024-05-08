package com.generator.exam.generator.services;

import com.generator.exam.generator.exceptions.EmptyListException;
import com.generator.exam.generator.exceptions.NotFoundException;
import com.generator.exam.generator.interfaces.QuestionService;
import com.generator.exam.generator.question.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions = new HashSet<>(Set.of());
    private final List<Question> questionList = new ArrayList<>(List.of());
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question questionNumber = new Question(question.toLowerCase(), answer.toLowerCase());
        return add(questionNumber);
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionNumber = new Question(question.toLowerCase(), answer.toLowerCase());
        return remove(questionNumber);
    }

    @Override
    public Collection<Question> getAll() {
        if (questions.isEmpty()) {
            throw new EmptyListException("List is empty");
        }
        return questions
                .stream()
                .toList();
    }

    @Override
    public Question getRandomQuestion() {
        questionList.addAll(getAll());
        return questionList.get(random.nextInt(questionList.size()));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.isEmpty()) {
            throw new EmptyListException("List is empty");
        } else if (!questions.contains(question)) {
            throw new NotFoundException("Вопрос не найден");
        } else {
            questions.remove(question);
            return question;
        }
    }

    @Override
    public Set<Question> getQuestions() {
        return questions;
    }
}