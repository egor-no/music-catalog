package com.testproject.learningspring.data.entity;

import javax.persistence.*;

@Entity
@Table(name="ARTIST")
public class Artist {
    @Id
    @Column(name="ARTIST_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long artistId;

    @Column(name="NAME")
    private String name;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="BIO")
    private String bio;

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }



}
