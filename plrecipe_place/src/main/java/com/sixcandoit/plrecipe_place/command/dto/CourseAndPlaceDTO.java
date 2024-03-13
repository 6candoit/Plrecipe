package com.sixcandoit.plrecipe_place.command.dto;

import com.sixcandoit.plrecipe_place.command.aggregate.Course;
import com.sixcandoit.plrecipe_place.command.aggregate.Place;
import com.sixcandoit.plrecipe_place.query.vo.ResponseMember;

import java.util.List;

public class CourseAndPlaceDTO {
    private int courseId;
    private String courseName;
    private ResponseMember member;
    private List<Place> places;

    public CourseAndPlaceDTO() {
    }

    public CourseAndPlaceDTO(int courseId, String courseName, ResponseMember member, List<Place> places) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.member = member;
        this.places = places;
    }

    public CourseAndPlaceDTO(int courseId, String courseName, List<Place> places) {
        this.courseId = courseId;
        this.courseName = courseName;
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

    public ResponseMember getMember() {
        return member;
    }

    public void setMember(ResponseMember member) {
        this.member = member;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "CourseAndPlaceDTO{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", member=" + member +
                ", places=" + places +
                '}';
    }
}