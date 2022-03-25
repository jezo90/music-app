import {Component, OnInit} from '@angular/core';
import {ArtistRequest} from "../../../services/artist/artist-request/artist-request";
import {ArtistService} from "../../../services/artist/artist.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-add-artist',
  templateUrl: './add-artist.component.html',
  styleUrls: ['./add-artist.component.css']
})
export class AddArtistComponent implements OnInit {

  file: File = new File([],'');
  newArtistId: number = 0;

  public artistRequest: ArtistRequest = new ArtistRequest('', '', '', new Date());

  constructor(private artistService: ArtistService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  onFileChange(event: any) {
    this.file = event.target.files[0];
  }

  addArtist() {
    this.artistService.addArtist(this.artistRequest, this.file).subscribe(
      data =>
      {
        this.dataToId(data);
        this.router.navigate(['../artist/' + this.newArtistId.toString()]).then();
      }
    );
  }

  dataToId(data: any)
  {
    this.newArtistId = data;
  }
}
