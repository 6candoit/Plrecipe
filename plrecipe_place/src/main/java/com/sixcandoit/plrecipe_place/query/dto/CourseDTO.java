package com.sixcandoit.plrecipe_place.query.dto;

import com.sixcandoit.plrecipe_place.query.vo.ResponseMember;


public class CourseDTO {
    private int courseId;
    private String courseName;

    private ResponseMember member;

    public CourseDTO() {
    }

    public CourseDTO(int courseId, String courseName, ResponseMember member) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.member = member;
    }

    public CourseDTO(String courseName, ResponseMember member) {
        this.courseName = courseName;
        this.member = member;
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

    public ResponseMember getMember() {
        return member;
    }

    public void setMember(ResponseMember member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", member=" + member +
                '}';
    }
}
