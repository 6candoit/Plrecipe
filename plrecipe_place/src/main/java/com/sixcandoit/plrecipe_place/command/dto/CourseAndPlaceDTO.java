package com.sixcandoit.plrecipe_place.command.dto;

import com.sixcandoit.plrecipe_place.command.aggregate.Course;
import com.sixcandoit.plrecipe_place.command.aggregate.Place;

import java.util.List;


public class CourseAndPlaceDTO {
    private int courseId;
    private String courseName;
    private int memberId;
    private List<Place> places;

    public CourseAndPlaceDTO() {
    }

    public CourseAndPlaceDTO(int courseId, String courseName, int memberId, List<Place> places) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.memberId = memberId;
        this.places = places;
    }

    public CourseAndPlaceDTO(Course course, List<Place> places){
        this.courseId = course.getCourseId();
        this.courseName = course.getCourseName();
        this.memberId = course.getMemberId();
        this.places = places;
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

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "CourseAndPlace{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", memberId=" + memberId +
                ", places=" + places +
                '}';
    }
}