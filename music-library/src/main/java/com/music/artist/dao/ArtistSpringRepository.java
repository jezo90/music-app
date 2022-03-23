package com.music.artist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistSpringRepository extends JpaRepository<ArtistEntity, Long> {
    Optional<ArtistEntity> findArtistEntitiesByImageName(String name);
}
