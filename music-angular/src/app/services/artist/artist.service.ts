import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {Artist} from "./artist";
import {ArtistRequest} from "./artist-request/artist-request";

const API_URL = 'http://localhost:9192/artist';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  error: any = null;

  constructor(private http: HttpClient) {
  }

  getArtists(): Observable<Artist[]> {
    return this.http.get<Artist[]>(API_URL);
  }

  getArtistById(id: number): Observable<Artist> {
    return this.http.get<Artist>(API_URL + '/' + id).pipe(
      catchError(this.handleError<Artist>(`artist id=${id}`))
    );
  }

  addArtist(artistRequest: ArtistRequest){
    return this.http.post(API_URL + "/add", artistRequest);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);
      this.error = `${operation} failed: ${error.message}`;

      return of(result as T);
    };
  }

}
