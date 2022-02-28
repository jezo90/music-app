package com.music.quiz.dao;

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
    public QuizEntity getQuizEntity(Long id) {
        return quizSpringRepository.getById(id);
    }

    @Override
    public Long addQuiz(QuizSaveDto quizSaveDto) {

        QuizEntity quizEntity = quizSpringRepository.save(QuizEntityMapper.map(quizSaveDto));

        refresh(quizEntity);

        return quizEntity.getId();
    }


    @Override
    public QuizResponseDto getById(Long id) {
        return QuizEntityMapper.map(
                quizSpringRepository.getById(id));
    }


}
