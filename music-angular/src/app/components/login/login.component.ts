import { Component, OnInit } from '@angular/core';
import {User} from "../../services/user/user";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication/authentication.service";
import {Token} from "../../services/tokenStorage/token";
import {TokenStorageService} from "../../services/tokenStorage/token-storage.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User('', '', '');
  token: Token = new Token('','','');
  error : any = null;

  constructor(private router: Router,
              private authService: AuthenticationService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if(this.tokenStorage.getToken()!=null)
    {
      this.router.navigate(['/']);
    }
  }

  handleLogin() {
    this.authService.login(this.user).subscribe(
      data => {
        this.save(data);
        console.log(this.tokenStorage.getToken());
        this.router.navigate(['../']);
      },
      er => {
        if (er.status === 401){
          this.error = 'Invalid email or password!';
        }
      }
    );
  }

  save(data: any){
    this.tokenStorage.signIn(data);
  }

}
