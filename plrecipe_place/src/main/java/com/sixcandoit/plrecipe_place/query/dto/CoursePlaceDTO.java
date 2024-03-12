package com.sixcandoit.plrecipe_place.query.dto;


public class CoursePlaceDTO {
    private int courseId;
    private int placeId;
    private int sequence;

    public CoursePlaceDTO() {
    }

    public CoursePlaceDTO(int courseId, int placeId, int sequence) {
        this.courseId = courseId;
        this.placeId = placeId;
        this.sequence = sequence;
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
        return "CoursePlaceDTO{" +
                "courseId=" + courseId +
                ", placeId=" + placeId +
                ", sequence=" + sequence +
                '}';
    }
}