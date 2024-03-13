package com.sixcandoit.plrecipe_place.query.aggregate;

import jakarta.persistence.*;

public class CoursePlace {
    private int placeCourseId;
    private int courseId;
    private int placeId;
    private int sequence;

    public CoursePlace() {
    }

    public CoursePlace(int placeCourseId, int courseId, int placeId, int sequence) {
        this.placeCourseId = placeCourseId;
        this.courseId = courseId;
        this.placeId = placeId;
        this.sequence = sequence;
    }

    public CoursePlace(int courseId, int placeId, int sequence) {
        this.courseId = courseId;
        this.placeId = placeId;
        this.sequence = sequence;
    }

    public int getPlaceCourseId() {
        return placeCourseId;
    }

    public void setPlaceCourseId(int placeCourseId) {
        this.placeCourseId = placeCourseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
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