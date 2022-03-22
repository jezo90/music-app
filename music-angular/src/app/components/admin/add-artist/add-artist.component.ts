import {Component, OnInit} from '@angular/core';
import {ArtistRequest} from "../../../services/artist/artist-request/artist-request";
import {ArtistService} from "../../../services/artist/artist.service";

@Component({
  selector: 'app-add-artist',
  templateUrl: './add-artist.component.html',
  styleUrls: ['./add-artist.component.css']
})
export class AddArtistComponent implements OnInit {

  file: File | null =  null;
  newArtistId: number = 0;

  public artistRequest: ArtistRequest = new ArtistRequest('', '', '', new Date(), null);

  constructor(private artistService: ArtistService) {
  }

  ngOnInit(): void {
  }

  onFileChange(event: any) {
    console.log(event.target.files[0]);
    this.artistRequest.image = event.target.files[0];
  }

  addArtist() {
    this.artistService.addArtist(this.artistRequest).subscribe(
      data =>
      {
        this.dataToId(data);
        console.log(this.newArtistId)
      }
    );
  }

  dataToId(data: any)
  {
    this.newArtistId = data;
  }
}
