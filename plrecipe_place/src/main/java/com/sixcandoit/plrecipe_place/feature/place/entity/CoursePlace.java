package com.sixcandoit.plrecipe_place.feature.place.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "plrecipe_course_and_place")
@Table(name = "course_place")
@Data
public class CoursePlace {

    @Id
    @Column(name = "place_course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeCourseId;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "place_id")
    private int placeId;

    @Column(name = "place_sequence")
    private int sequence;

    public CoursePlace() {
    }

    public CoursePlace(int placeCourseId, int courseId, int placeId, int sequence) {
        this.placeCourseId = placeCourseId;
        this.courseId = courseId;
        this.placeId = placeId;
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "CoursePlace{" +
                "placeCourseId=" + placeCourseId +
                ", courseId=" + courseId +
                ", placeId=" + placeId +
                ", sequence=" + sequence +
                '}';
    }
}