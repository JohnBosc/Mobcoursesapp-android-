package com.finalyear.mobcoursesapp.entities;

import android.annotation.TargetApi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Lesson {

    @PrimaryKey
    private int lessonID;

    private String lessonTitle;

    private int course;  // index by courseID

    private List<Title> titles;


    public Lesson() {
    }

    public Lesson(int lessonID, String lessonTitle, int course, List<Title> titles) {
        this.lessonID = lessonID;
        this.lessonTitle = lessonTitle;
        this.course = course;
        this.titles = titles;
    }



    // Getters

    public int getLessonID() {
        return lessonID;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public int getCourse() {
        return course;
    }

    public List<Title> getTitles() {
        return titles;
    }


    //Setters


    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }
}
