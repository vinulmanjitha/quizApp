package com.vinul.quizapp.repository;

import com.vinul.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByQuestionContainingIgnoreCase(String keyword);
}
