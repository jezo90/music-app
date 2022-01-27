package com.music.album.dao;

import com.music.album.dto.AlbumDetailsResponseDto;
import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;
import com.music.album.dto.TrackDetailsDto;
import com.music.artist.dao.ArtistEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumEntityMapper {
    public static AlbumResponseDto map(AlbumEntity albumEntity) {
        return new AlbumResponseDto(
                albumEntity.getId(),
                albumEntity.getCdName(),
                albumEntity.getReleaseDate(),
                albumEntity.getArtistEntity().getId().toString());
    }

    public static List<AlbumResponseDto> map(List<AlbumEntity> albumEntityList) {
        return albumEntityList
                .stream()
                .map(AlbumEntityMapper::map)
                .collect(Collectors.toList());
    }

    public static AlbumEntity map(AlbumRequestDto albumRequestDto) {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setCdName(albumRequestDto.cdName());
        albumEntity.setReleaseDate(albumRequestDto.releaseDate());
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setId(albumRequestDto.artistId());
        albumEntity.setArtistEntity(artistEntity);

        return albumEntity;
    }

    public static AlbumDetailsResponseDto mapToDetails(AlbumEntity albumEntity) {
        return new AlbumDetailsResponseDto(
                albumEntity.getCdName(),
                albumEntity.getReleaseDate(),
                albumEntity.getArtistEntity().getNickname());
    }

    public static List<TrackDetailsDto> mapToList(AlbumEntity albumEntity) {
        return albumEntity
                .getTrackList()
                .stream()
                .map(trackEntity ->
                        new TrackDetailsDto(
                                trackEntity.getId(),
                                trackEntity.getText())).collect(Collectors.toList());

    }

}
