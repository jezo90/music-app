import { Injectable } from '@angular/core';
import {catchError, Observable, of} from "rxjs";
import {Artist} from "../artist/artist";
import {HttpClient} from "@angular/common/http";
import {Album} from "./album";

const API_URL = 'http://localhost:9192/album';
@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  error: any = null;

  constructor(private http: HttpClient) { }

  getAlbumsByArtistId(id: number): Observable<Album[]> {
    return this.http.get<Album[]>(API_URL + '/byArtistId/' + id).pipe(
      catchError(this.handleError<Album[]>(`artist id=${id}`))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);
      this.error = `${operation} failed: ${error.message}`;

      return of(result as T);
    };
  }

}
