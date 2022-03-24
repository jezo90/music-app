package com.music.album.dao;

import com.music.album.dto.*;
import com.music.artist.dao.ArtistEntity;
import com.music.artist.dto.ArtistImageDto;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AlbumEntityMapper {
    public static AlbumResponseDto map(AlbumEntity albumEntity) {
        return new AlbumResponseDto(
                albumEntity.getId(),
                albumEntity.getCdName(),
                albumEntity.getReleaseDate(),
                albumEntity.getArtistEntity().getId().toString()
        );
    }

    public static List<AlbumResponseDto> map(List<AlbumEntity> albumEntityList) {
        return albumEntityList
                .stream()
                .map(AlbumEntityMapper::map)
                .collect(Collectors.toList());
    }

    public static AlbumEntity map(AlbumRequestDto albumRequestDto) throws IOException {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setCdName(albumRequestDto.cdName());
        albumEntity.setReleaseDate(albumRequestDto.releaseDate());
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setId(albumRequestDto.artistId());
        albumEntity.setArtistEntity(artistEntity);

        albumEntity.setImageName(
                StringUtils.cleanPath(
                        Objects.requireNonNull(
                                albumRequestDto.image()
                                        .getOriginalFilename())));
        albumEntity.setImageType(
                albumRequestDto.image()
                        .getContentType());
        albumEntity.setImage(albumRequestDto
                .image()
                .getBytes());


        return albumEntity;
    }

    public static AlbumDetailsResponseDto mapToDetails(AlbumEntity albumEntity) {
        return new AlbumDetailsResponseDto(
                albumEntity.getId(),
                albumEntity.getCdName(),
                albumEntity.getReleaseDate(),
                albumEntity.getArtistEntity().getNickname(),
                albumEntity.getImageName()
        );
    }

    public static List<TrackDetailsDto> mapToList(AlbumEntity albumEntity) {
        return albumEntity
                .getTrackList()
                .stream()
                .map(trackEntity ->
                             new TrackDetailsDto(
                                     trackEntity.getId(),
                                     trackEntity.getTitle(),
                                     trackEntity.getText()
                             )).collect(Collectors.toList());

    }


    public static AlbumImageDto mapToImageDto(AlbumEntity albumEntity)
    {
        return new AlbumImageDto
                (albumEntity.getImageName(),
                        albumEntity.getImageType(),
                        albumEntity.getImage());
    }

}
