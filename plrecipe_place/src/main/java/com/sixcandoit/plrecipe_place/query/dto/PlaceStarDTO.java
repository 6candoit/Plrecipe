package com.sixcandoit.plrecipe_place.query.dto;


import com.sixcandoit.plrecipe_place.query.aggregate.Place;
import com.sixcandoit.plrecipe_place.query.vo.ResponseMember;

public class PlaceStarDTO {

    private int starId;
    private int starPoint;
    private String starComment;
    private Place place;
    private ResponseMember member;

    public PlaceStarDTO() {
    }

    public PlaceStarDTO(int starId, int starPoint, String starComment, Place place, ResponseMember member) {
        this.starId = starId;
        this.starPoint = starPoint;
        this.starComment = starComment;
        this.place = place;
        this.member = member;
    }

    public PlaceStarDTO(int starPoint, String starComment, Place place, ResponseMember member) {
        this.starPoint = starPoint;
        this.starComment = starComment;
        this.place = place;
        this.member = member;
    }

    public int getStarId() {
        return starId;
    }

    public void setStarId(int starId) {
        this.starId = starId;
    }

    public int getStarPoint() {
        return starPoint;
    }

    public void setStarPoint(int starPoint) {
        this.starPoint = starPoint;
    }

    public String getStarComment() {
        return starComment;
    }

    public void setStarComment(String starComment) {
        this.starComment = starComment;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public ResponseMember getMember() {
        return member;
    }

    public void setMember(ResponseMember member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "PlaceStarDTO{" +
                "starId=" + starId +
                ", starPoint=" + starPoint +
                ", starComment='" + starComment + '\'' +
                ", place=" + place +
                ", member=" + member +
                '}';
    }
}
