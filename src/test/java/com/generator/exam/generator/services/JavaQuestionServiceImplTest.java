package com.generator.exam.generator.services;

import com.generator.exam.generator.exceptions.EmptyListException;
import com.generator.exam.generator.exceptions.NotFoundException;
import com.generator.exam.generator.interfaces.QuestionService;
import com.generator.exam.generator.question.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceImplTest {
    private final QuestionService questionService = new JavaQuestionServiceImpl();
    private Set<Question> questionsSet;
    private List<Question> questionList;
    private String questionOne;
    private String answerOne;
    private String questionTwo;
    private String answerTwo;
    private String questionThree;
    private String answerThree;
    private Question questionOneTest;
    private Question questionTwoTest;
    private Question questionThreeTest;

    @BeforeEach
    public void setUp() {
        questionOne = "Вопрос1";
        answerOne = "Ответ1";
        questionTwo = "Вопрос2";
        answerTwo = "Ответ2";
        questionThree = "Вопрос3";
        answerThree = "Ответ3";
        questionOneTest = new Question(questionOne.toLowerCase(), answerOne.toLowerCase());
        questionTwoTest = new Question(questionTwo.toLowerCase(), answerTwo.toLowerCase());
        questionThreeTest = new Question(questionThree.toLowerCase(), answerThree.toLowerCase());
        questionsSet = new HashSet<>(Set.of(questionOneTest, questionTwoTest, questionThreeTest));
        questionList = new ArrayList<>(List.of(questionOneTest, questionTwoTest, questionThreeTest));
    }

    @Test
    public void addQuestionTest() {
        questionService.add(questionTwo.toLowerCase(), answerTwo.toLowerCase());
        questionService.add(questionTwo.toLowerCase(), answerTwo.toLowerCase());
        questionService.add(questionThree.toLowerCase(), answerThree.toLowerCase());
        assertEquals(questionOneTest, questionService.add(questionOne, answerOne));
        assertEquals(3, questionService.getQuestions().size());
        assertEquals(questionsSet, questionService.getQuestions());
    }

    @Test
    public void addQuestionObjectTest() {
        questionService.add(questionOneTest);
        questionService.add(questionTwoTest);
        questionService.add(questionThreeTest);
        questionService.add(questionThreeTest);
        assertEquals(questionOneTest, questionService.add(questionOneTest));
        assertEquals(3, questionService.getQuestions().size());
        assertEquals(questionsSet, questionService.getQuestions());
    }

    @Test
    public void removeQuestionTest() {
        questionService.add(questionTwo.toLowerCase(), answerTwo.toLowerCase());
        questionService.add(questionTwo.toLowerCase(), answerTwo.toLowerCase());
        questionService.add(questionThree.toLowerCase(), answerThree.toLowerCase());
        questionService.add(questionOne.toLowerCase(), answerOne.toLowerCase());
        questionsSet.remove(questionThreeTest);
        assertEquals(questionThreeTest, questionService.remove(questionThree.toLowerCase(), answerThree.toLowerCase()));
        assertEquals(2, questionService.getQuestions().size());
        assertEquals(questionsSet, questionService.getQuestions());
    }

    @Test
    public void removeQuestionObjectTest() {
        assertThrows(EmptyListException.class, () -> questionService.remove(questionOneTest));
        questionService.add(questionTwoTest);
        assertThrows(NotFoundException.class, () -> questionService.remove(questionOneTest));
        assertEquals(questionTwoTest, questionService.remove(questionTwoTest));
    }

    @Test
    public void getAllQuestionTest() {
        assertThrows(EmptyListException.class, () -> questionService.getAll());
        questionService.add(questionOne.toLowerCase(), answerOne.toLowerCase());
        questionService.add(questionTwo.toLowerCase(), answerTwo.toLowerCase());
        questionService.add(questionTwo.toLowerCase(), answerTwo.toLowerCase());
        questionService.add(questionThree.toLowerCase(), answerThree.toLowerCase());
        assertEquals(3, questionService.getAll().size());
        assertEquals(questionList, questionService.getAll());
    }
}