import {Component, OnInit} from '@angular/core';
import {Quiz} from "../../services/quiz/quiz";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  public quiz: Quiz = new Quiz(0,0,'', 0, '', 0, '', 0, '');

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,

    ) {
  }

  ngOnInit(): void {
    console.log(history.state.data);
  }


}
