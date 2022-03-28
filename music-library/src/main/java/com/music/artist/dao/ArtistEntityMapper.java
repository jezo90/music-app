package com.music.artist.dao;

import com.music.artist.dto.ArtistImageDto;
import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Slf4j
public class ArtistEntityMapper {

    public static ArtistResponseDto map(ArtistEntity artistEntity) {

        return new ArtistResponseDto(
                artistEntity.getId(),
                artistEntity.getNickname(),
                artistEntity.getFirstName(),
                artistEntity.getLastName(),
                artistEntity.getBirthDate(),
                artistEntity.getImageName()
        );
    }

    public static ArtistEntity map(ArtistRequestDto artistRequestDto) {

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
        try {

            artistEntity.setImage(artistRequestDto
                    .image()
                    .getBytes());
        } catch (Exception ex) {
            log.info("Image is not valid");
        }
        return artistEntity;
    }

    public static ArtistImageDto mapToImageDto(ArtistEntity artistEntity) {
        return new ArtistImageDto
                (artistEntity.getImageName(),
                        artistEntity.getImageType(),
                        artistEntity.getImage());
    }

}
