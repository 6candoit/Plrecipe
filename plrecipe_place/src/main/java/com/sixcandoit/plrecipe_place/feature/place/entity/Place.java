package com.sixcandoit.plrecipe_place.feature.place.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "plrecipe_place")
@Table(name = "place")
public class Place {

    @Id
    @Column(name = "place_id")
    private int placeId;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "place_location")
    private String placeLocation;

    @Column(name = "place_phone_num")
    private String placePhoneNum;

    @Column(name = "place_category_id")
    private int placeCategoryId;

    public Place() {
    }

    public Place(int placeId, String placeName, String placeLocation, String placePhoneNum, int placeCategoryId) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placePhoneNum = placePhoneNum;
        this.placeCategoryId = placeCategoryId;
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

    public int getPlaceCategoryId() {
        return placeCategoryId;
    }

    public void setPlaceCategoryId(int placeCategoryId) {
        this.placeCategoryId = placeCategoryId;
    }

    @Override
    public String toString() {
        return "PlaceDTO{" +
                "placeId=" + placeId +
                ", placeName='" + placeName + '\'' +
                ", placeLocation='" + placeLocation + '\'' +
                ", placePhoneNum='" + placePhoneNum + '\'' +
                ", placeCategoryId=" + placeCategoryId +
                '}';
    }
}
