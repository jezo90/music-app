package com.music.album.dao;

import com.music.artist.dao.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumSpringRepository extends JpaRepository<AlbumEntity, Long> {
    List<AlbumEntity> findAlbumEntitiesByArtistEntity_Id(Long id);
    Optional<AlbumEntity> findAlbumEntitiesByImageName(String name);
}
