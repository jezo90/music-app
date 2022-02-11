package com.music.album.dao;

import com.music.artist.dao.ArtistEntity;
import com.music.track.dao.TrackEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "album")
@NoArgsConstructor
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cdName;
    private Date releaseDate;
    private String image;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistEntity artistEntity;

    @OneToMany(mappedBy = "albumEntity")
    private List<TrackEntity> trackList;
}

