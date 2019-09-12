package com.finalyear.mobcoursesapp.entities;

import android.annotation.TargetApi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class CourseAuthor {

    @PrimaryKey
    private Long courseAuthorID;

    private String name;

    private List<Course> courses;

    private String email;

    private String password;

    private String phone;


    public CourseAuthor() {
    }

    public CourseAuthor(Long courseAuthorID, String name, List<Course> courses, String email, String password, String phone) {
        this.courseAuthorID = courseAuthorID;
        this.name = name;
        this.courses = courses;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }



    //Getters

    public Long getCourseAuthorID() {
        return courseAuthorID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }


    //Setters


    public void setCourseAuthorID(Long courseAuthorID) {
        this.courseAuthorID = courseAuthorID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
