package com.music.track.api;

import com.music.track.mapper.TrackMapper;
import com.music.track.model.TrackRequest;
import com.music.track.model.TrackResponse;
import com.music.track.port.inbound.TrackComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/track")
class TrackController {
    private final TrackComponent trackComponent;

    @GetMapping("/{id}")
    ResponseEntity<TrackResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(
                TrackMapper
                        .map(trackComponent
                                     .get(id)));
    }


    @PostMapping("/add")
    ResponseEntity<TrackResponse> add(@RequestBody TrackRequest trackRequest) {
        return ResponseEntity.ok(
                TrackMapper.map(
                        trackComponent.add(
                                TrackMapper.map(trackRequest))));
    }

}