package com.music.artist.dao;

import com.music.artist.dto.ArtistImageDto;
import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArtistEntityMapper {

    public static ArtistResponseDto map(ArtistEntity artistEntity) {

        return new ArtistResponseDto(
                artistEntity.getId(),
                artistEntity.getNickname(),
                artistEntity.getFirstName(),
                artistEntity.getLastName(),
                artistEntity.getBirthDate(),
                artistEntity.getImage()

        );
    }

    public static ArtistEntity map(ArtistRequestDto artistRequestDto) throws IOException {

        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setNickname(artistRequestDto.nickname());
        artistEntity.setFirstName(artistRequestDto.firstName());
        artistEntity.setLastName(artistRequestDto.lastName());
        artistEntity.setBirthDate(artistRequestDto.birthDate());
        artistEntity.setImageName(
                StringUtils.cleanPath(
                        Objects.requireNonNull(
                                artistRequestDto.image()
                                        .getOriginalFilename())));
        artistEntity.setImageType(
                artistRequestDto.image()
                        .getContentType());
        artistEntity.setImage(artistRequestDto
                .image()
                .getBytes());

        return artistEntity;
    }

    public static ArtistImageDto mapToImageDto(ArtistEntity artistEntity)
    {
        return new ArtistImageDto
                (artistEntity.getImageName(),
                        artistEntity.getImageType(),
                        artistEntity.getImage());
    }

}
