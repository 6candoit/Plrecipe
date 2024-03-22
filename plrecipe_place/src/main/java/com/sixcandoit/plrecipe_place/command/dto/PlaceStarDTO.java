package com.sixcandoit.plrecipe_place.command.dto;

import com.sixcandoit.plrecipe_place.query.vo.ResponseMember;
import lombok.Data;

public class PlaceStarDTO {

    private int starId;
    private int starPoint;
    private String starComment;
    private PlaceDTO place;
    private ResponseMember member;

    public PlaceStarDTO() {
    }

    public PlaceStarDTO(int starId, int starPoint, String starComment, PlaceDTO place, ResponseMember member) {
        this.starId = starId;
        this.starPoint = starPoint;
        this.starComment = starComment;
        this.place = place;
        this.member = member;
    }

    public PlaceStarDTO(int starPoint, String starComment, PlaceDTO place, ResponseMember member) {
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

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(PlaceDTO place) {
        this.place = place;
    }

    public ResponseMember getMember() {
        return member;
    }

    public void setMember(ResponseMember member) {
        this.member = member;
    }

}
