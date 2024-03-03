package com.sixcandoit.plrecipe_place.feature.place.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "plrecipe_place_star")
@Table(name = "place_star")
public class PlaceStar {

    @Id
    @Column(name = "star_id")
    private int starId;

    @Column(name = "star_point")
    private int starPoint;

    @Column(name = "star_comment")
    private String starComment;

    @Column(name = "place_id")
    private int placeId;

    @Column(name = "member_email")
    private String memberEmail;

    public PlaceStar() {
    }

    public PlaceStar(int starId, int starPoint, String starComment, int placeId, String memberEmail) {
        this.starId = starId;
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
