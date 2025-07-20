package com.vinul.quizapp.service;

import com.vinul.quizapp.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();

    Question getQuestionById(Integer id);

    Question createQuestion(Question question);

    Question updateQuestion(Integer id, Question updatedQuestion);

    void deleteQuestion(Integer id);

    List<Question> searchQuestions(String keyword);
}
