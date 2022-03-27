import {Component, OnInit} from '@angular/core';
import {AlbumRequest} from "../../../services/album/album-request/album-request";
import {AlbumService} from "../../../services/album/album.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TokenStorageService} from "../../../services/tokenStorage/token-storage.service";

@Component({
  selector: 'app-add-album',
  templateUrl: './add-album.component.html',
  styleUrls: ['./add-album.component.css']
})
export class AddAlbumComponent implements OnInit {

  artistId: number = 0;
  file: File = new File([], '');
  public albumRequest: AlbumRequest = new AlbumRequest('', new Date());

  constructor(private albumService: AlbumService,
              private route: ActivatedRoute,
              private router: Router,
              private tokenService: TokenStorageService) {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.artistId = +this.route.snapshot.paramMap.get('id');
  }

  onFileChange(event: any) {
    this.file = event.target.files[0];
  }

  addAlbum() {
    this.albumService.addAlbum(this.albumRequest, this.file, this.artistId).subscribe(
      r =>
      {
        this.router.navigate(['../artist/' + this.artistId]).then();
      }
    );

  }

}
