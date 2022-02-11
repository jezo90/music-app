package com.music.artist.dao;

import com.music.album.dao.AlbumEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "artist")
@NoArgsConstructor
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String image;

    @OneToMany(mappedBy = "artistEntity")
    private List<AlbumEntity> albumList;
}
