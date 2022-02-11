import {Component, OnInit} from '@angular/core';
import {ArtistService} from "../../services/artist/artist.service";
import {ActivatedRoute} from "@angular/router";
import {Artist} from "../../services/artist/artist";

@Component({
  selector: 'app-artist-details',
  templateUrl: './artist-details.component.html',
  styleUrls: ['./artist-details.component.css']
})
export class ArtistDetailsComponent implements OnInit {

  private artistId: number = 0;
  private newDate: Date | undefined;
  public artist: Artist = new Artist(0, '', '', '', 0);

  constructor(private artistService: ArtistService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.artistId = +this.route.snapshot.paramMap.get('id');
    this.artistService.getArtistById(this.artistId).subscribe(
      data => {
        this.responseToObject(data);
      }
    );
  }

  responseToObject(artistData: any) {
    this.artist = artistData;
    console.log(artistData);
  }

  convertToDate(date: any)
  {
    this.newDate = new Date(date);
    return this.newDate;
  }

}
