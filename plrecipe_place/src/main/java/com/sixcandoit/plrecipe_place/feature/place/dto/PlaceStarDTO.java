package com.sixcandoit.plrecipe_place.feature.place.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class PlaceStarDTO {

    private int starId;
    private int starPoint;
    private String starComment;
    private int placeId;
    private String memberEmail;

    public PlaceStarDTO() {
    }

    public PlaceStarDTO(int starId, int starPoint, String starComment, int placeId, String memberEmail) {
        this.starId = starId;
        this.starPoint = starPoint;
        this.starComment = starComment;
        this.placeId = placeId;
        this.memberEmail = memberEmail;
    }

    public PlaceStarDTO(int starPoint, String starComment, int placeId, String memberEmail) {
        this.starPoint = starPoint;
        this.starComment = starComment;
        this.placeId = placeId;
        this.memberEmail = memberEmail;
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

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    @Override
    public String toString() {
        return "PlaceStarDTO{" +
                "starId=" + starId +
                ", starPoint=" + starPoint +
                ", starComment='" + starComment + '\'' +
                ", placeId=" + placeId +
                ", memberEmail='" + memberEmail + '\'' +
                '}';
    }
}
