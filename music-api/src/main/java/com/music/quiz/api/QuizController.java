package com.music.quiz.api;

import com.music.quiz.mapper.QuizMapper;
import com.music.quiz.model.QuizCreate;
import com.music.quiz.model.QuizRequest;
import com.music.quiz.model.QuizResponse;
import com.music.quiz.model.QuizSave;
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

    @GetMapping
    ResponseEntity<QuizCreate> createQuiz(@RequestBody QuizRequest quizRequest) {

        return ResponseEntity.ok(
                QuizMapper.map(
                        quizComponent.createQuiz(
                                QuizMapper.map(quizRequest))));
    }

    @PostMapping("/addQuiz")
    ResponseEntity<Long> AddQuiz(@RequestBody QuizSave quizSave)
    {
        return ResponseEntity.ok(
                quizComponent.addQuiz(
                        QuizMapper.map(
                                quizSave)));
    }


    @GetMapping("/{id}")
    ResponseEntity<QuizResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(
                QuizMapper.map(
                        quizComponent.getById(id)));

    }


}
