package com.sixcandoit.plrecipe_place.feature.place.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class PlaceDTO {

    private int placeId;
    private String placeName;
    private String placeLocation;
    private String placePhoneNum;
    private int placeCategoryId;

    public PlaceDTO(int placeId, String placeName, String placeLocation, String placePhoneNum, int placeCategoryId) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placePhoneNum = placePhoneNum;
        this.placeCategoryId = placeCategoryId;
    }

    public PlaceDTO(String placeName, String placeLocation, String placePhoneNum, int placeCategoryId) {
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placePhoneNum = placePhoneNum;
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
