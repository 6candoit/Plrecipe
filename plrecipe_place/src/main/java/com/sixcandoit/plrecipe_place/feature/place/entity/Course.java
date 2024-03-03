package com.sixcandoit.plrecipe_place.feature.place.entity;

import jakarta.persistence.*;

@Entity(name = "plrecipe_course")
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "member_email")
    private String memberEmail;

    public Course() {
    }

    public Course(int courseId, String courseName, String memberEmail) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.memberEmail = memberEmail;
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

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                '}';
    }
}
