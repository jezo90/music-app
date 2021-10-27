package com.music.artist.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
}
