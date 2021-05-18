package com.codingcrew.audify.model;

public class Audio {
    private int id;
    private float duration;
    private String artist;
    private String link;
    private String name;
    private String thumbnail;
    private int playCount;
    private int likeCount;


    public Audio(int id, float duration, String artist, String link, String name, String thumbnail, int playCount, int likeCount) {
        this.id = id;
        this.duration = duration;
        this.artist = artist;
        this.link = link;
        this.name = name;
        this.thumbnail = thumbnail;
        this.playCount = playCount;
        this.likeCount = likeCount;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", duration=" + duration +
                ", artist=" + artist +
                ", link=" + link +
                ", name='" + name + '\'' +
                ", thumbnail=" + thumbnail +
                ", playCount=" + playCount +
                ", likeCount=" + likeCount +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
