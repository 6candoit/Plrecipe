package com.sixcandoit.plrecipe_place.feature.place.entity;

import jakarta.persistence.*;

import java.util.List;

public class CourseAndPlace {
    private int placeCourseId;
    private Course course;       // ManyToOne
    private List<Place> places;  // OneToMany

    public CourseAndPlace() {
    }

    public CourseAndPlace(int placeCourseId, Course course, List<Place> places) {
        this.placeCourseId = placeCourseId;
        this.course = course;
        this.places = places;
    }

    public int getPlaceCourseId() {
        return placeCourseId;
    }

    public void setPlaceCourseId(int placeCourseId) {
        this.placeCourseId = placeCourseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
                "placeCourseId=" + placeCourseId +
                ", course=" + course +
                ", places=" + places +
                '}';
    }
}