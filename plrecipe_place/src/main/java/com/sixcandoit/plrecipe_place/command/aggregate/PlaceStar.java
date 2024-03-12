package com.sixcandoit.plrecipe_place.command.aggregate;

import jakarta.persistence.*;

@Entity(name = "plrecipe_place_star")
@Table(name = "place_star")
public class PlaceStar {

    @Id
    @Column(name = "star_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int starId;

    @Column(name = "star_point")
    private int starPoint;

    @Column(name = "star_comment")
    private String starComment;

    @Column(name = "place_id")
    private int placeId;

    @Column(name = "member_id")
    private int memberId;

    public PlaceStar() {
    }

    public PlaceStar(int starId, int starPoint, String starComment, int placeId, int memberId) {
        this.starId = starId;
        this.starPoint = starPoint;
        this.starComment = starComment;
        this.placeId = placeId;
        this.memberId = memberId;
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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "PlaceStar{" +
                "starId=" + starId +
                ", starPoint=" + starPoint +
                ", starComment='" + starComment + '\'' +
                ", placeId=" + placeId +
                ", memberId=" + memberId +
                '}';
    }
}
