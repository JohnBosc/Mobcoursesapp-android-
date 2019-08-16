package com.finalyear.mobcoursesapp.entities;

public class Course {

    private String course_name;
    private String course_description;
    private String course_requirements;
    private int Thumbnail;

    public Course() {
    }

    public Course(String course_name, String course_description, String course_requirements, int thumbnail) {
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_requirements = course_requirements;
        Thumbnail = thumbnail;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_requirements() {
        return course_requirements;
    }

    public void setCourse_requirements(String course_requirements) {
        this.course_requirements = course_requirements;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
