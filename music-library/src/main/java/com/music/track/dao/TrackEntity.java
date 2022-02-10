package com.music.track.dao;

import com.music.album.dao.AlbumEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "track")
@NoArgsConstructor
public class TrackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String text;
    private Boolean feat;

    @ManyToOne
    @JoinColumn(name = "albumId")
    private AlbumEntity albumEntity;
}
