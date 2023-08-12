package com.adinz.quize.repository;

import com.adinz.quize.modal.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllByCategory(String category);
    @Query(value = "SELECT * FROM question q Where q.category=:category LIMIT :noQ", nativeQuery = true)
    List<Question> createRandomQuestionUsingTypeandNoQ(String category, int noQ);
}
