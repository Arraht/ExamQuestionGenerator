package com.generator.exam.generator.services;

import com.generator.exam.generator.exceptions.BadAmountException;
import com.generator.exam.generator.exceptions.EmptyListException;
import com.generator.exam.generator.interfaces.QuestionService;
import com.generator.exam.generator.question.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Mock
    private QuestionService questionService;
    private Set<Question> questionSetTest;
    private List<Question> questionListTest;
    private Question questionOneTest;
    private Question questionTwoTest;
    private Question questionThreeTest;
    private Question questionFourTest;

    @BeforeEach
    public void setUp() {
        String questionOne = "Вопрос1";
        String answerOne = "Ответ1";
        String questionTwo = "Вопрос2";
        String answerTwo = "Ответ2";
        String questionThree = "Вопрос3";
        String answerThree = "Ответ3";
        String questionFour = "Вопрос4";
        String answerFour = "Ответ4";
        questionOneTest = new Question(questionOne.toLowerCase(), answerOne.toLowerCase());
        questionTwoTest = new Question(questionTwo.toLowerCase(), answerTwo.toLowerCase());
        questionThreeTest = new Question(questionThree.toLowerCase(), answerThree.toLowerCase());
        questionFourTest = new Question(questionFour.toLowerCase(), answerFour.toLowerCase());
        questionSetTest = new HashSet<>(Set.of());
        questionListTest = new ArrayList<>(List.of(questionOneTest, questionTwoTest, questionThreeTest, questionFourTest));
    }

    @Test
    public void getQuestionMoreRequestsTest() {
        when(questionService.getAll()).thenReturn(questionListTest);
        assertThrows(BadAmountException.class, () -> examinerService.getQuestion(5));
    }

    @Test
    public void getQuestionRequestZeroOrLessTest() {
        when(questionService.getAll()).thenReturn(questionListTest);
        assertThrows(BadAmountException.class, () -> examinerService.getQuestion(0));
        assertThrows(BadAmountException.class, () -> examinerService.getQuestion(-5));
    }

    @Test
    public void getQuestionEmptyListExceptionTest() {
        when(questionService.getAll()).thenReturn(questionListTest);
        questionListTest.clear();
        assertThrows(EmptyListException.class, () -> examinerService.getQuestion(3));
    }

    /*@Test
    public void getQuestionTest() {
        when(questionService.getAll()).thenReturn(questionListTest);
        assertEquals(2, examinerService.getQuestion(2));
    }*/
}