package com.sixcandoit.plrecipe.feature.place;

public class Course {

    private int courseId;
    private String courseName;
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
