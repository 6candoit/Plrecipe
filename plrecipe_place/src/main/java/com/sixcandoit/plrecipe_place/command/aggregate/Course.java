package com.sixcandoit.plrecipe_place.command.aggregate;

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

    @Column(name = "member_id")
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
