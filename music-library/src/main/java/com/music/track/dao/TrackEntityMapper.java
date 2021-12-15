package com.music.track.dao;

import com.music.album.dao.AlbumEntity;
import com.music.track.dto.TrackRequestDto;
import com.music.track.dto.TrackResponseDto;

public class TrackEntityMapper {

    public static TrackResponseDto map(TrackEntity trackEntity)
    {
        return new TrackResponseDto(
                trackEntity.getTitle(),
                trackEntity.getText(),
                trackEntity.getFeat()
        );
    }

    public static TrackEntity map(TrackRequestDto trackRequestDto)
    {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setId(trackRequestDto.getAlbum_id());

        TrackEntity trackEntity = new TrackEntity();
        trackEntity.setTitle(trackRequestDto.getTitle());
        trackEntity.setText(trackRequestDto.getText());
        trackEntity.setFeat(trackRequestDto.getFeat());
        trackEntity.setAlbumEntity(albumEntity);

        return trackEntity;
    }

}
