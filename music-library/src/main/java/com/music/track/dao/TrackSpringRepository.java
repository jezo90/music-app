package com.music.track.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackSpringRepository extends JpaRepository<TrackEntity, Long> {
}
