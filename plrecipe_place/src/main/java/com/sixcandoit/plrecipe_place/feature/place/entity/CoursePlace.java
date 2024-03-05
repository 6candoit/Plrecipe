package com.sixcandoit.plrecipe_place.feature.place.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "plrecipe_course_place")
@Table(name = "course_place")
public class CoursePlace {

    @Id
    @Column(name = "place_course_id")
    private int placeCourseId;

    @JoinColumn(name = "courseId")
    @ManyToOne
    private Course course;

    @OneToMany(mappedBy="placeId")
    private List<Place> places;

    public CoursePlace() {
    }

    public CoursePlace(int placeCourseId, Course course, List<Place> places) {
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
        return "CoursePlace{" +
                "placeCourseId=" + placeCourseId +
                ", course=" + course +
                ", places=" + places +
                '}';
    }
}