package com.adinz.quize.repository;

import com.adinz.quize.modal.Quize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quize, Integer> {
}
