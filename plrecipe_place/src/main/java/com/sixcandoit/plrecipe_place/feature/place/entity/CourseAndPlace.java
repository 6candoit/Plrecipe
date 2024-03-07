package com.sixcandoit.plrecipe_place.feature.place.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseAndPlace {
    private int courseId;
    private String courseName;
    private int memberId;
    private List<Place> places;

    public CourseAndPlace() {
    }

    public CourseAndPlace(Course course, List<Place> places){
        this.courseId = course.getCourseId();
        this.courseName = course.getCourseName();
        this.memberId = course.getMemberId();
        this.places = places;
    }
}