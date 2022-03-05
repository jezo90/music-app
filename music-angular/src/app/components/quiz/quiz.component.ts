import {Component, OnInit} from '@angular/core';
import {Quiz} from "../../services/quiz/quiz";
import {ActivatedRoute, Router} from "@angular/router";
import {QuizService} from "../../services/quiz/quiz.service";
import {QuizRequest} from "../../services/quiz/quiz-request";
import {QuizSave} from "../../services/quiz/quiz-save";
import {TokenStorageService} from "../../services/tokenStorage/token-storage.service";

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  public quiz: Quiz = new Quiz(0, '', 0, '', 0, '', '', 0);
  private quizRequest: QuizRequest = new QuizRequest(0, 0, 0);
  private quizSave: QuizSave = new QuizSave("", 0, 0,0,"",0,0);
  private quizId = 0;


  constructor(private router: Router,
              private route: ActivatedRoute,
              private quizService: QuizService,
              private tokenStorage: TokenStorageService
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

  responseToNumber(data: number) {
    this.quizId = data;
  }

  addQuiz(trackId: number) {
    console.log("token: " + this.tokenStorage.getToken());
    console.log("username " + this.tokenStorage.getUsernameString());
    console.log("role " + this.tokenStorage.getRoles());


    this.quizSave = new QuizSave(
      this.tokenStorage.getUsernameString(),
      this.quiz.firstTrackId,
      this.quiz.secondTrackId,
      this.quiz.thirdTrackId,
      this.quiz.words,
      this.quiz.correctAnswerId,
      trackId);

    this.quizService.addQuiz(this.quizSave).subscribe(
      data => {
        this.responseToNumber(data);
      }
    );


  }

}
