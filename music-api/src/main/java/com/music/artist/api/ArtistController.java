package com.music.artist.api;

import com.music.artist.mapper.ArtistMapper;
import com.music.artist.model.ArtistRequest;
import com.music.artist.model.ArtistResponse;
import com.music.artist.port.inbound.ArtistComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
    ResponseEntity<ArtistResponse> add(@RequestBody ArtistRequest artistRequest, @RequestParam("file") MultipartFile file) throws IOException {

        return ResponseEntity.ok(
                ArtistMapper.map(
                        artistComponent.add(
                                ArtistMapper.map(artistRequest, file))));
    }

}