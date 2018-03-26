package ru.bstu.vt41.bli.thridandroidapp;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Post implements Serializable {
    private String title;
    private String text;
    private int imageID;
    private Date time;

    public Post(String title, String text, int imageID, Date time) {
        this.title = title;
        this.text = text;
        this.imageID = imageID;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Time date) {
        this.time = time;
    }
}
