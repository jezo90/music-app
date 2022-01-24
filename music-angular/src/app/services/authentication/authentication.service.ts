import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from "../user/user";

const AUTH_API = 'http://localhost:9192/';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  login(user: User){
    return this.http.post(AUTH_API + 'login', user);
  }

  register(user: User) {
    return this.http.post(AUTH_API + 'register', user);
  }
}
