package com.music.artist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistSpringRepository extends JpaRepository<ArtistEntity, Long> {
    List<ArtistEntity> findArtistEntitiesByImageName(String name);
}
