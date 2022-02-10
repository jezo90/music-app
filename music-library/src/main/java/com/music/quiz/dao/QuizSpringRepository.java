package com.music.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizSpringRepository extends JpaRepository<QuizEntity, Long> {
}
