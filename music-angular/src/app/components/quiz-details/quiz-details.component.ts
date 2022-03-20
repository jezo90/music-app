import {Component, OnInit} from '@angular/core';
import {QuizResponse} from "../../services/quiz/models/quiz-response/quiz-response";
import {ActivatedRoute, Router} from "@angular/router";
import {QuizService} from "../../services/quiz/quiz.service";

@Component({
  selector: 'app-quiz-details',
  templateUrl: './quiz-details.component.html',
  styleUrls: ['./quiz-details.component.css']
})
export class QuizDetailsComponent implements OnInit {

  public quizResponse: QuizResponse = new QuizResponse(0, 0, '', 0, '',
    0, '', '', 0, 0);
  private quizId: number = 0;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private quizService: QuizService) {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.quizId = +this.route.snapshot.paramMap.get('id');
    this.getQuizDetails();
  }

  getQuizDetails(): void {
    this.quizService.getQuiz(this.quizId).subscribe(
      data => {
        this.dataToQuiz(data);
      }
    );
  }

  dataToQuiz(data: any) {
    this.quizResponse = data;
  }

  setClass(id: number) {
    return {
      'btn-success': this.quizResponse.correctAnswerId == id,
      'btn-danger': this.quizResponse.correctAnswerId != id && this.quizResponse.userAnswerId == id,
      'btn-dark': this.quizResponse.correctAnswerId != id && this.quizResponse.userAnswerId != id
    }
  }
}
