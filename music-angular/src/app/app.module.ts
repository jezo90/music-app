import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {AppRoutingModule} from "./app-routing.module";
import {NavComponent} from "./components/nav/nav.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {ArtistComponent} from './components/artist/artist.component';
import {ArtistDetailsComponent} from './components/artist-details/artist-details.component';
import {QuizComponent} from './components/quiz/quiz.component';
import {QuizDetailsComponent} from './components/quiz-details/quiz-details.component';
import {AddArtistComponent} from './components/admin/add-artist/add-artist.component';
import { AddAlbumComponent } from './components/admin/add-album/add-album.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    NavComponent,
    ArtistComponent,
    ArtistDetailsComponent,
    QuizComponent,
    QuizDetailsComponent,
    AddArtistComponent,
    AddAlbumComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
