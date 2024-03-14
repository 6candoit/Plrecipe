package com.sixcandoit.plrecipe_place.query.dto;

import com.sixcandoit.plrecipe_place.query.vo.ResponseMember;

public class PlaceStarDTO {

    private int starId;
    private int starPoint;
    private String starComment;
    private int placeId;
    private ResponseMember member;

    public PlaceStarDTO() {
    }

    public PlaceStarDTO(int starId, int starPoint, String starComment, int placeId) {
        this.starId = starId;
        this.starPoint = starPoint;
        this.starComment = starComment;
        this.placeId = placeId;
    }

    public PlaceStarDTO(int starPoint, String starComment, int placeId, ResponseMember member) {
        this.starPoint = starPoint;
        this.starComment = starComment;
        this.placeId = placeId;
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

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
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
                ", placeId=" + placeId +
                ", member=" + member +
                '}';
    }
}
