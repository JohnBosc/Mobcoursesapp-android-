package com.finalyear.mobcoursesapp.entities;

import android.annotation.TargetApi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Title {

    @PrimaryKey
    private int titleID;

    private String titleName;

    private int lesson; // index by lessonID

    private String content;



    public Title() {
    }


    public Title(int titleID, String titleName, int lesson, String content) {
        this.titleID = titleID;
        this.titleName = titleName;
        this.lesson = lesson;
        this.content = content;
    }


    //Getters

    public int getTitleID() {
        return titleID;
    }

    public String getTitleName() {
        return titleName;
    }

    public int getLesson() {
        return lesson;
    }

    public String getContent() {
        return content;
    }


    //Setters


    public void setTitleID(int titleID) {
        this.titleID = titleID;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
