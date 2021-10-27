package com.music.albums.api;
import com.music.album.port.inbound.AlbumComponent;
import com.music.albums.mapper.AlbumMapper;
import com.music.albums.model.AlbumRequest;
import com.music.albums.model.AlbumResponse;
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
    ResponseEntity<List<AlbumResponse>> getAll()
    {
        return ResponseEntity.ok(
                AlbumMapper.map(
                        albumComponent.getAll()));
    }

    @PostMapping("/add")
    ResponseEntity<AlbumResponse> add(AlbumRequest albumRequest)
    {
        return ResponseEntity.ok(
                AlbumMapper.map(
                        albumComponent.add(
                                AlbumMapper.map(albumRequest))));
    }



}