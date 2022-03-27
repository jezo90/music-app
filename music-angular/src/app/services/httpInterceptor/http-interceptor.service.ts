import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {TokenStorageService} from "../tokenStorage/token-storage.service";
import {catchError, Observable, throwError} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {

  constructor(private token: TokenStorageService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = request;
    const token = this.token.getToken();
    if (token != null) {
      authReq = request.clone({
          setHeaders: {
            Authorization: 'Bearer ' + token,
            'Content-Type': 'application/json'
          }
        });
    }
    return next.handle(authReq).pipe(catchError(err => {
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
