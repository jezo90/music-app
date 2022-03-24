import {Component, OnInit} from '@angular/core';
import {ArtistService} from "../../services/artist/artist.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Artist} from "../../services/artist/artist";
import {AlbumService} from "../../services/album/album.service";
import {Album} from "../../services/album/album";

@Component({
  selector: 'app-artist-details',
  templateUrl: './artist-details.component.html',
  styleUrls: ['./artist-details.component.css']
})
export class ArtistDetailsComponent implements OnInit {

  private artistId: number = 0;
  private newDate: Date | undefined;
  public quizId: string = "";
  public artist: Artist = new Artist(0, '', '', '', 0, 'default.jpg');
  public albums: Array<Album> = [];

  constructor(private artistService: ArtistService,
              private albumService: AlbumService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.artistId = +this.route.snapshot.paramMap.get('id');
    this.getArtistDetails(this.artistId);
    this.getAlbumsByArtistId(this.artistId);
  }

  getArtistDetails(id: any): void {
    this.artistService.getArtistById(id).subscribe(
      data => {
        this.responseToArtist(data);
      }
    );
  }

  getAlbumsByArtistId(id: any): void {
    this.albumService.getAlbumsByArtistId(id).subscribe(
      data => {
        this.responseToAlbums(data);
      }
    );
  }

  responseToArtist(artistData: any) {
    this.artist = artistData;
  }

  responseToAlbums(albumsData: any) {
    this.albums = albumsData;
  }


  convertToDate(date: any) {
    this.newDate = new Date(date);
    return this.newDate;
  }

  createQuiz(albumId: number, artistId: number, numberOfWords: number) {

    this.router.navigate(['/quiz'],
      {
        queryParams: {
          albumId,
          artistId,
          numberOfWords
        }
      }).then(r => r);
  }

}
