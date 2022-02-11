package com.music.album.api;

import com.music.album.mapper.AlbumMapper;
import com.music.album.model.AlbumDetailsResponse;
import com.music.album.model.AlbumRequest;
import com.music.album.model.AlbumResponse;
import com.music.album.port.inbound.AlbumComponent;
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
    ResponseEntity<List<AlbumResponse>> getAll() {
        return ResponseEntity.ok(
                AlbumMapper.map(
                        albumComponent.getAll()));
    }

    @PostMapping("/add")
    ResponseEntity<AlbumResponse> add(@RequestBody AlbumRequest albumRequest) {
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

}