import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ArtistComponent} from "./components/artist/artist.component";
import {ArtistDetailsComponent} from "./components/artist-details/artist-details.component";
import {QuizComponent} from "./components/quiz/quiz.component";
import {QuizDetailsComponent} from "./components/quiz-details/quiz-details.component";
import {AddArtistComponent} from "./components/admin/add-artist/add-artist.component";
import {AddAlbumComponent} from "./components/admin/add-album/add-album.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'artist', component: ArtistComponent},
  {path: 'artist/:id', component: ArtistDetailsComponent},
  {path: 'quiz', component: QuizComponent},
  {path: 'quiz/:id', component: QuizDetailsComponent},
  {path: 'admin/addArtist', component: AddArtistComponent},
  {path: 'admin/addAlbum/:id', component: AddAlbumComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
