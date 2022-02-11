package com.music.album.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumSpringRepository extends JpaRepository<AlbumEntity, Long> {
    List<AlbumEntity> findAlbumEntitiesByArtistEntity_Id(Long id);
}
