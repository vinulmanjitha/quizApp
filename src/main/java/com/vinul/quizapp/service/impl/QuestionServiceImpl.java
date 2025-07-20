package com.vinul.quizapp.service.impl;

import com.vinul.quizapp.entity.Question;
import com.vinul.quizapp.repository.QuestionRepository;
import com.vinul.quizapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestions() {
        log.info("Fetching all questions");
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Integer id) {
        log.info("Fetching question with id {}", id);
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    @Override
    public Question createQuestion(Question question) {
        log.info("Creating question: {}", question.getQuestion());
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Integer id, Question updatedQuestion) {
        log.info("Updating question with id {}", id);
        Question existing = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
        existing.setQuestion(updatedQuestion.getQuestion());
        existing.setOption1(updatedQuestion.getOption1());
        existing.setOption2(updatedQuestion.getOption2());
        existing.setOption3(updatedQuestion.getOption3());
        existing.setOption4(updatedQuestion.getOption4());
        existing.setAnswer(updatedQuestion.getAnswer());
        return questionRepository.save(existing);
    }

    @Override
    public void deleteQuestion(Integer id) {
        log.info("Deleting question with id {}", id);
        Question existing = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
        questionRepository.delete(existing);
    }

    @Override
    public List<Question> searchQuestions(String keyword) {
        log.info("Searching questions with keyword {}", keyword);
        return questionRepository.findByQuestionContainingIgnoreCase(keyword);
    }
}
