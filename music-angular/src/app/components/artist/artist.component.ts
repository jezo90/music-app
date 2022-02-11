import {Component, OnInit} from '@angular/core';
import {ArtistService} from "../../services/artist/artist.service";
import {Artist} from "../../services/artist/artist";

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.css']
})
export class ArtistComponent implements OnInit {

  data : any;
  error : any = null;
  artists : Array<Artist> = [];


  constructor(private artistService: ArtistService) {
  }

  ngOnInit(): void {
    this.generateArtist();
  }

  generateArtist() : any
  {
    this.artistService.getArtists().subscribe(
      data => {
        this.responseToObject(data);
      }
    );
    return this.data;
  }

  responseToObject(artist: any){
    this.artists = artist;
  }
}
