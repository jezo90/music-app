import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ArtistComponent} from "./components/artist/artist.component";
import {ArtistDetailsComponent} from "./components/artist-details/artist-details.component";
import {QuizComponent} from "./components/quiz/quiz.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'artist', component: ArtistComponent},
  {path: 'artist/:id', component: ArtistDetailsComponent},
  {path: 'quiz/:id', component: QuizComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
