package com.music.album.dao;

import com.music.artist.dao.ArtistEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistEntity artistEntity;
}

