package com.music.album.model;

import java.util.Date;

public record AlbumRequest (
    String cdName,
    Date releaseDate,
    Long artistId
){}
