import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Quiz} from "./quiz";
import {QuizRequest} from "./quiz-request";
import {catchError, Observable, of} from "rxjs";
import {QuizSave} from "./quiz-save";


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

    console.log(quizSave.userId);
    return this.http.post<number>(AUTH_API + "/addQuiz", quizSave).pipe(
      catchError(this.handleError<number>(`chosenAnswerId=${quizSave.chosenAnswerId}`))
    );
  }

}
