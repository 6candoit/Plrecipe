package com.sixcandoit.plrecipe_place.feature.place.dto;

public class CourseDTO {
    private String courseName;
    private int memberId;

    public CourseDTO() {
    }

    public CourseDTO(String courseName, int memberId) {
        this.courseName = courseName;
        this.memberId = memberId;
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
        return "CourseDTO{" +
                "courseName='" + courseName + '\'' +
                ", memberId=" + memberId +
                '}';
    }
}
