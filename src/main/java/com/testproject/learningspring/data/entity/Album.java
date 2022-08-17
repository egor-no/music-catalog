package com.testproject.learningspring.data.entity;

import javax.persistence.*;

@Entity
@Table(name="ALBUM")
public class Album {

    @Id
    @Column(name="ALBUM_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long albumId;

    @Column(name="TITLE")
    private String title;

    @Column(name="ARTIST_ID")
    private long artistID;

    @Column(name="YEAR")
    private int year;

    @Column(name="INFO")
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getArtistID() {
        return artistID;
    }

    public void setArtistID(long artistID) {
        this.artistID = artistID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
