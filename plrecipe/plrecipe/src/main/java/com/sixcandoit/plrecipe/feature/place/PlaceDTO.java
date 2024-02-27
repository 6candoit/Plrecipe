package com.sixcandoit.plrecipe.feature.place;

public class PlaceDTO {
    private int placeId;
    private String placeName;
    private String placeLocation;
    private String placePhoneNum;
    private int placeCategoryId;

    public PlaceDTO() {
    }

    public PlaceDTO(int placeId, String placeName, String placeLocation, String placePhoneNum, int placeCategoryId) {
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
