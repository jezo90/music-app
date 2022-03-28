package com.music.artist.api;

import com.music.artist.mapper.ArtistMapper;
import com.music.artist.model.ArtistImage;
import com.music.artist.model.ArtistRequest;
import com.music.artist.model.ArtistResponse;
import com.music.artist.port.inbound.ArtistComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/artist")
@CrossOrigin("*")
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
    ResponseEntity<Long> add(@RequestParam("file") MultipartFile file,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("nickname") String nickname,
                             @RequestParam("birthDate") String birthDate){

        SimpleDateFormat formatter = new SimpleDateFormat("d.MM.yyyy", Locale.ENGLISH);
        Date date = new Date();

        try {
            date = formatter.parse(birthDate);
        } catch (Exception exception) {
            log.info("Date is not valid");
        }

        ArtistRequest artistRequest = new ArtistRequest(nickname, firstName, lastName, date);

        return ResponseEntity.ok(
                artistComponent.add(
                        ArtistMapper.map(artistRequest, file)));
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