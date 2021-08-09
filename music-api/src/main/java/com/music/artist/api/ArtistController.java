package com.music.artist.api;


import com.music.artist.mapper.ArtistMapper;
import com.music.artist.model.ArtistResponse;
import com.music.artist.port.inbound.ArtistComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/artists")
class ArtistController {

    private final ArtistComponent artistComponent;

    @GetMapping
    ResponseEntity<List<ArtistResponse>> getAllArtists()
    {
        return ResponseEntity
                .ok(ArtistMapper
                        .map(artistComponent
                        .getAllArtists()));
    }

    @GetMapping("/{id}")
    ResponseEntity<ArtistResponse> getArtist(@PathVariable Long id)
    {
        return ResponseEntity.ok(
                ArtistMapper
                .map(artistComponent
                        .getArtist(id)));
    }

    @PostMapping
    ResponseEntity<ArtistResponse> addArtist(@RequestBody ArtistResponse artistResponse)
    {
        return ResponseEntity.ok(
                ArtistMapper.map(
                        artistComponent.addArtist(
                                ArtistMapper.map(artistResponse))));
    }




}