package com.lamda.web.music;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name="music") @Component
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicSeq;
    @Column(length = 4, nullable = false)
    private String seq;
    @Column(length = 200, nullable = false)
    private String title;
    @Column(length = 200, nullable = false)
    private String artists;
    @Column(length = 500, nullable = false)
    private String thumbnail;

    public Music(){}

    @Builder
    public Music(String seq, String title, String artists,
                 String thumbnail) {
        this.seq = seq;
        this.title = title;
        this.artists = artists;
        this.thumbnail = thumbnail;
    }

    public Long getMusicSeq() {
        return musicSeq;
    }

    public void setMusicSeq(Long musicSeq) {
        this.musicSeq = musicSeq;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}

