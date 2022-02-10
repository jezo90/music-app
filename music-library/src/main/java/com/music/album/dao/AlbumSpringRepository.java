package com.music.album.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumSpringRepository extends JpaRepository<AlbumEntity, Long> {
}
