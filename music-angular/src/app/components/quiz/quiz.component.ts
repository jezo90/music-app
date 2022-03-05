import {Component, OnInit} from '@angular/core';
import {Quiz} from "../../services/quiz/quiz";
import {ActivatedRoute, Router} from "@angular/router";
import {QuizService} from "../../services/quiz/quiz.service";
import {QuizRequest} from "../../services/quiz/quiz-request";

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  public quiz: Quiz = new Quiz(0, '', 0, '', 0, '', '', 0);
  private quizRequest: QuizRequest = new QuizRequest(0, 0, 0);


  constructor(private router: Router,
              private route: ActivatedRoute,
              private quizService: QuizService
  ) {
  }

  ngOnInit(): void {

    this.quizRequest.artistId = Number(this.route.snapshot.queryParamMap.get('artistId'));
    this.quizRequest.albumId = Number(this.route.snapshot.queryParamMap.get('albumId'));
    this.quizRequest.numberOfWords = Number(this.route.snapshot.queryParamMap.get('numberOfWords'));

    this.quizService.generateQuiz(this.quizRequest).subscribe(
      data => {
        this.responseToQuiz(data);
      }
    )
  }

  responseToQuiz(quizData: any) {
    this.quiz = quizData;
  }

}
