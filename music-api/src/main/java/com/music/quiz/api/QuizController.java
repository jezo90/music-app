package com.music.quiz.api;

import com.music.quiz.mapper.QuizMapper;
import com.music.quiz.model.QuizRequest;
import com.music.quiz.model.QuizResponse;
import com.music.quiz.port.inbound.QuizComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizComponent quizComponent;

    @PostMapping
    ResponseEntity<QuizResponse> createQuiz(@RequestBody QuizRequest quizRequest)
    {
        return ResponseEntity.ok(
                QuizMapper.map(
                        quizComponent.createQuiz(
                                QuizMapper.map(quizRequest))));
    }
}
