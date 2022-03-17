import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Quiz} from "./models/quiz/quiz";
import {QuizRequest} from "./models/quiz-request/quiz-request";
import {catchError, Observable, of} from "rxjs";
import {QuizSave} from "./quiz-save";
import {QuizResponse} from "./models/quiz-response/quiz-response";
import {Artist} from "../artist/artist";


const AUTH_API = 'http://localhost:9192/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  error: any = null;

  constructor(private http: HttpClient) {
  }

  generateQuiz(quizRequest: QuizRequest): Observable<Quiz> {

    const params = new HttpParams()
      .set('albumId', quizRequest.albumId)
      .set('artistId', quizRequest.artistId)
      .set('numberOfWords', quizRequest.numberOfWords);

    return this.http.get<Quiz>(AUTH_API, {params}).pipe(
      catchError(this.handleError<Quiz>(`album id=${quizRequest.albumId}`))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);
      this.error = `${operation} failed: ${error.message}`;

      return of(result as T);
    };
  }

  addQuiz(quizSave: QuizSave): Observable<number> {

    return this.http.post<number>(AUTH_API + "/addQuiz", quizSave).pipe(
      catchError(this.handleError<number>(`chosenAnswerId=${quizSave.chosenAnswerId}`))
    );
  }

  getQuiz(id: number): Observable<QuizResponse> {

    return this.http.get<QuizResponse>(AUTH_API + '/get' + id).pipe(
      catchError(this.handleError<QuizResponse>(`chosenAnswerId=${id}`))
    );
  }
}
