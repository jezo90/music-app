import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Quiz} from "./quiz";
import {QuizRequest} from "./quiz-request";


const AUTH_API = 'http://localhost:9192/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http: HttpClient) { }

  generateQuiz(quizRequest : QuizRequest){
    // @ts-ignore
    return this.http.get(AUTH_API, quizRequest);
  }
}
