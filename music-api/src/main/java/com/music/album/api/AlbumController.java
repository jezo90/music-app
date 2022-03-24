package com.music.album.api;

import com.music.album.mapper.AlbumMapper;
import com.music.album.model.AlbumDetailsResponse;
import com.music.album.model.AlbumImage;
import com.music.album.model.AlbumRequest;
import com.music.album.model.AlbumResponse;
import com.music.album.port.inbound.AlbumComponent;
import com.music.artist.mapper.ArtistMapper;
import com.music.artist.model.ArtistImage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/album")
class AlbumController {

    private final AlbumComponent albumComponent;

    @GetMapping
    ResponseEntity<List<AlbumResponse>> getAll() {
        return ResponseEntity.ok(
                AlbumMapper.map(
                        albumComponent.getAll()));
    }

    @PostMapping("/add")
    ResponseEntity<AlbumResponse> add(@RequestParam("file") MultipartFile file,
                                      @RequestParam("cdName") String cdName,
                                      @RequestParam("releaseDate") String releaseDate,
                                      @RequestParam("artistId") Long artistId) throws ParseException, IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("d.MM.yyyy", Locale.ENGLISH);
        Date date = formatter.parse(releaseDate);

        AlbumRequest albumRequest = new AlbumRequest(cdName,date, artistId, file);

        return ResponseEntity.ok(
                AlbumMapper.map(
                        albumComponent.add(
                                AlbumMapper.map(albumRequest))));
    }

    @GetMapping("/{id}")
    ResponseEntity<AlbumDetailsResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(
                AlbumMapper.map(
                        albumComponent.get(id)));
    }

    @GetMapping("/byArtistId/{id}")
    ResponseEntity<List<AlbumDetailsResponse>> getByArtistId(@PathVariable Long id) {
        return ResponseEntity.ok(
                AlbumMapper.mapToDetails(
                        albumComponent.getByArtistId(id)));
    }

    @GetMapping(path = {"/image/{name}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) {

        final AlbumImage image = AlbumMapper.map(albumComponent.findImageByName(name));

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(image.imageType()))
                .body(image.image());
    }

}