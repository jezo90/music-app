import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {TokenStorageService} from "../tokenStorage/token-storage.service";
import {catchError, Observable, throwError} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor{

  constructor(private token: TokenStorageService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler) : Observable<HttpEvent<any>>  {
    const token = this.token.getToken();
    return next.handle(request).pipe(catchError(err => {
      if (err.status === 401) {

        // auto logout if 401 response returned from api
        //this.token.signOut();
        //location.reload();

      }

      const error = err.error.message || err.statusText;
      return throwError(error);
    }))
  }
}
