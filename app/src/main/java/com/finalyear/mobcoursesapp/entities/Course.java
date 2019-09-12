package com.finalyear.mobcoursesapp.entities;

import android.annotation.TargetApi;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;
import static androidx.room.ForeignKey.RESTRICT;


public class Course {


    private int courseID;

    private String courseTitle;

    private int subject;   // index by subjectID

    private int courseAuthor; // index by courseAuthorID

    private String courseDescription;

    private String otherDetails;

    private String requirements;

    private String photo;
//            = "http://192.168.1.104/mobcoursesapp/thumbnails/" + courseTitle + ".jpg";


    public Course() {
    }

    public Course(int courseID, String courseTitle, int subject, int courseAuthor,
                  String courseDescription, String otherDetails, String requirements, String photo) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.subject = subject;
        this.courseAuthor = courseAuthor;
        this.courseDescription = courseDescription;
        this.otherDetails = otherDetails;
        this.requirements = requirements;
        this.photo = photo;
    }

    // Getters

    public int getCourseID() {
        return courseID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getSubject() {
        return subject;
    }

    public int getCourseAuthor() {
        return courseAuthor;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getPhoto() {
        return photo;
    }

    // Setters

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public void setCourseAuthor(int courseAuthor) {
        this.courseAuthor = courseAuthor;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
