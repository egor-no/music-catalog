package com.testproject.learningspring.data.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="FORMAT")
public class Format {

    @Id
    @Column(name="FORMAT_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long formatId;

    @Column(name="RELEASE_DATE")
    private Date releaseDate;

    @Column(name="ALBUM_ID")
    private long albumId;

    @Column(name="FORMAT")
    private String format;

    @Column(name="NOTES")
    private String notes;

    @Column(name="LABEL")
    private String label;

    @Column(name="PRICE")
    private int price;

    @Column(name="IMG")
    private String img;

    public String getImg() {
        return img;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getFormatId() {
        return formatId;
    }

    public void setFormatId(long formatId) {
        this.formatId = formatId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
