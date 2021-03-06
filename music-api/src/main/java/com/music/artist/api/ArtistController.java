package com.music.artist.api;

import com.music.artist.mapper.ArtistMapper;
import com.music.artist.model.ArtistImage;
import com.music.artist.model.ArtistRequest;
import com.music.artist.model.ArtistResponse;
import com.music.artist.port.inbound.ArtistComponent;
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
@RequestMapping("/artist")
class ArtistController {
    private final ArtistComponent artistComponent;

    @GetMapping
    ResponseEntity<List<ArtistResponse>> getAllArtists() {
        return ResponseEntity
                .ok(ArtistMapper
                        .map(artistComponent
                                .getAll()));
    }

    @GetMapping("/{id}")
    ResponseEntity<ArtistResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(
                ArtistMapper
                        .map(artistComponent
                                .get(id)));
    }

    @PostMapping("/add")
    ResponseEntity<ArtistResponse> add(@RequestParam("file") MultipartFile file,
                                       @RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("nickname") String nickname,
                                       @RequestParam("birthDate") String birthDate) throws IOException, ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("d.MM.yyyy", Locale.ENGLISH);
        Date date = formatter.parse(birthDate);

        ArtistRequest artistRequest = new ArtistRequest(nickname, firstName, lastName, date);

        return ResponseEntity.ok(
                ArtistMapper.map(
                        artistComponent.add(
                                ArtistMapper.map(artistRequest, file))));
    }

    @GetMapping(path = {"/image/{name}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) {

        final ArtistImage image = ArtistMapper.map(artistComponent.findImageByName(name));

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(image.imageType()))
                .body(image.image());
    }
}