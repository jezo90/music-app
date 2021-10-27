package com.music.albums.api;


import com.music.artist.mapper.ArtistMapper;
import com.music.artist.model.ArtistRequest;
import com.music.artist.model.ArtistResponse;
import com.music.artist.port.inbound.ArtistComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/album")
class AlbumController {

    private final AlbumComponent albumComponent;

    @GetMapping
    ResponseEntity<List<ArtistResponse>> getAll()
    {
        return ResponseEntity
                .ok(ArtistMapper
                        .map(albumComponent
                        .getAll()));
    }
}