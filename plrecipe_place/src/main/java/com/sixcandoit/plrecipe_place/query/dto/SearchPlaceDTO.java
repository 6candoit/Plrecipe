package com.sixcandoit.plrecipe_place.query.dto;


public class SearchPlaceDTO {
    private String placeName;
    private String placeLocation;
    private String placePhoneNum;

    public SearchPlaceDTO() {
    }

    public SearchPlaceDTO(String placeName, String placeLocation, String placePhoneNum) {
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placePhoneNum = placePhoneNum;
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

    @Override
    public String toString() {
        return "SearchPlaceDTO{" +
                "placeName='" + placeName + '\'' +
                ", placeLocation='" + placeLocation + '\'' +
                ", placePhoneNum='" + placePhoneNum + '\'' +
                '}';
    }
}
