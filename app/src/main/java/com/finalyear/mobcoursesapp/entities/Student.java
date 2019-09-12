package com.finalyear.mobcoursesapp.entities;

import android.annotation.TargetApi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Collection;

@Entity
public class Student {

    @PrimaryKey
    private int studentID;

    private String name;

    private String password;

    private String email;

    private String phone;

    private Collection<Course> courseCollection;


    public Student() {
    }


    public Student(int studentID, String name, String password, String email, String phone, Collection<Course> courseCollection) {
        this.studentID = studentID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.courseCollection = courseCollection;
    }



    //Getters

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }


    //Setters


    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }
}
