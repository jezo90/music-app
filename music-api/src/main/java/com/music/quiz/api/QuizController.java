package com.music.quiz.api;

import com.music.quiz.mapper.QuizMapper;
import com.music.quiz.model.AnswerRequest;
import com.music.quiz.model.QuizRequest;
import com.music.quiz.model.QuizResponse;
import com.music.quiz.port.inbound.QuizComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
    private final QuizComponent quizComponent;

    @PostMapping
    ResponseEntity<Long> createQuiz(@RequestBody QuizRequest quizRequest) {

        return ResponseEntity.ok(
                quizComponent.createQuiz(
                        QuizMapper.map(quizRequest)));
    }

    @PutMapping("/answer")
    ResponseEntity<QuizResponse> updateAnswer(@RequestBody AnswerRequest answerRequest) {
        return ResponseEntity.ok(
                QuizMapper.map(
                        quizComponent.updateAnswer(
                                QuizMapper.map(answerRequest))));

    }

    @GetMapping("/{id}")
    ResponseEntity<QuizResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(
                QuizMapper.map(
                        quizComponent.getById(id)));

    }


}
