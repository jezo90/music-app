import {Component, OnInit} from '@angular/core';
import {User} from "../../services/user/user";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication/authentication.service";
import {Token} from "../../services/tokenStorage/token";
import {TokenStorageService} from "../../services/tokenStorage/token-storage.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User('', '', '');
  error: any = null;
  token: Token = new Token('', '', '');

  constructor(private router: Router,
              private authService: AuthenticationService,
              private tokenStorage: TokenStorageService) {
  }


  ngOnInit(): void {
  }

  handleRegister() {
    this.authService.register(this.user).subscribe(
      data => {
        this.save(data);
        this.router.navigate(['']);
      },
      error => {
        if (error.status === 404) {
          this.error = 'Username/email is taken!';
        } else if (error.status === 500) {
          this.error = 'Invalid data!';
        }
      }
    );
  }

  save(data: any) {
    this.tokenStorage.signIn(data);
  }

}
