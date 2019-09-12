package com.finalyear.mobcoursesapp.entities;

import android.annotation.TargetApi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Subject {

    @PrimaryKey
    private int subjectID;

    private String subjectName;

    private List<Course> courses;


    public Subject() {
    }

    public Subject(int subjectID, String subjectName, List<Course> courses) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.courses = courses;
    }

    //Getters

    public int getSubjectID() {
        return subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public List<Course> getCourses() {
        return courses;
    }


    //Setters


    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
