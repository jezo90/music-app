import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Token} from "./token";


const TOKEN_KEY = 'token';
const USERNAME_KEY = 'username';
const ROLES_KEY = 'roles';
const USER_ID = "0";


@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  isLogged: boolean | undefined;

  constructor(private router: Router) { }

  signOut() {
    window.sessionStorage.clear();
    this.isLogged = false;
    this.router.navigate(['/']);
  }

  public signIn(token: Token) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.removeItem(USERNAME_KEY);
    window.sessionStorage.removeItem(ROLES_KEY);
    window.sessionStorage.removeItem(USER_ID);
    window.sessionStorage.setItem(USERNAME_KEY, token.username);
    window.sessionStorage.setItem(TOKEN_KEY, token.token);
    window.sessionStorage.setItem(ROLES_KEY, token.roles);
    window.sessionStorage.setItem(USER_ID, String(+token.id));
    this.isLogged = true;
  }

  public getToken(): string {
    return <string>window.sessionStorage.getItem(TOKEN_KEY);
  }

  public getUsername() {
    return JSON.parse(<string>window.sessionStorage.getItem(USERNAME_KEY));
  }

  public getId(): number{
    return Number(window.sessionStorage.getItem(USER_ID));
  }

  public getRoles() {
    return window.sessionStorage.getItem(ROLES_KEY);
  }

  public isAdmin(){
    const roles = window.sessionStorage.getItem(ROLES_KEY);
    if (roles != null && this.isLogged) {

      // @ts-ignore
      return window.sessionStorage.getItem(ROLES_KEY).includes('ROLE_ADMIN');
    }
    return false;
  }
}
