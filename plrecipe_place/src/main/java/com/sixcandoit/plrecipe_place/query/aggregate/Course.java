package com.sixcandoit.plrecipe_place.query.aggregate;

import jakarta.persistence.*;

public class Course {
    private int courseId;
    private String courseName;
    private int memberId;

    public Course() {
    }

    public Course(int courseId, String courseName, int memberId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.memberId = memberId;
    }

    public Course(String courseName, int memberId) {
        this.courseName = courseName;
        this.memberId = memberId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
