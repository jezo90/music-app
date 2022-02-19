package com.music.quiz.dao;

import com.music.quiz.dto.AnswerRequestDto;
import com.music.quiz.dto.QuizCreateDto;
import com.music.quiz.dto.QuizResponseDto;
import com.music.quiz.port.outbound.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Component
@RequiredArgsConstructor
class QuizAdapter implements QuizRepository {
    private final EntityManager entityManager;
    private final QuizSpringRepository quizSpringRepository;

    @Transactional
    public void refresh(QuizEntity t) {
        entityManager.refresh(t);
    }

    @Override
    @Transactional
    public QuizResponseDto createQuiz(QuizCreateDto quizCreateDto) {

        QuizEntity quizEntity = quizSpringRepository.save(
                QuizEntityMapper.map(quizCreateDto));
        refresh(quizEntity);
        return QuizEntityMapper.map(quizEntity);
    }

    @Override
    public QuizEntity getQuizEntity(Long id) {
        return quizSpringRepository.getById(id);
    }

    @Override
    public QuizResponseDto updateAnswer(QuizEntity quizEntity) {
        quizSpringRepository.save(quizEntity);

        return QuizEntityMapper.map(quizEntity);
    }




}
