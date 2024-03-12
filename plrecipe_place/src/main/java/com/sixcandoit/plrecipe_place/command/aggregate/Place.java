package com.sixcandoit.plrecipe_place.command.aggregate;

import jakarta.persistence.*;

@Entity(name = "plrecipe_place")
@Table(name = "place")
public class Place {

    @Id
    @Column(name = "place_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeId;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "place_location")
    private String placeLocation;

    @Column(name = "place_phone_num")
    private String placePhoneNum;

    @JoinColumn(name = "place_category_id")
    @ManyToOne
    private PlaceCategory placeCategory;

    public Place() {
    }

    public Place(int placeId, String placeName, String placeLocation, String placePhoneNum, PlaceCategory placeCategory) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placePhoneNum = placePhoneNum;
        this.placeCategory = placeCategory;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }

    public String getPlacePhoneNum() {
        return placePhoneNum;
    }

    public void setPlacePhoneNum(String placePhoneNum) {
        this.placePhoneNum = placePhoneNum;
    }

    public PlaceCategory getPlaceCategory() {
        return placeCategory;
    }

    public void setPlaceCategory(PlaceCategory category) {
        this.placeCategory = category;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", placeName='" + placeName + '\'' +
                ", placeLocation='" + placeLocation + '\'' +
                ", placePhoneNum='" + placePhoneNum + '\'' +
                ", placeCategory=" + placeCategory +
                '}';
    }
}
