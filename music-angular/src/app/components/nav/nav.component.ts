import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../../services/tokenStorage/token-storage.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(private tokenStorage: TokenStorageService) {
  }

  ngOnInit(): void {
  }

  handleLogout() {
    this.tokenStorage.signOut();
  }

}
