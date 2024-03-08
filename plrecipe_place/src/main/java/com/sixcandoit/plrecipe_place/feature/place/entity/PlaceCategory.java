package com.sixcandoit.plrecipe_place.feature.place.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "plrecipe_category")
@Table(name = "place_category")
public class PlaceCategory {

    @Id
    @Column(name = "place_category_id")
    private int placeCategoryId;

    @Column(name = "place_category_name")
    private String placeCategoryName;

    public PlaceCategory() {
    }

    public PlaceCategory(int placeCategoryId, String placeCategoryName) {
        this.placeCategoryId = placeCategoryId;
        this.placeCategoryName = placeCategoryName;
    }

    public int getPlaceCategoryId() {
        return placeCategoryId;
    }

    public void setPlaceCategoryId(int placeCategoryId) {
        this.placeCategoryId = placeCategoryId;
    }

    public String getPlaceCategoryName() {
        return placeCategoryName;
    }

    public void setPlaceCategoryName(String placeCategoryName) {
        this.placeCategoryName = placeCategoryName;
    }

    @Override
    public String toString() {
        return "PlaceCategory{" +
                "placeCategoryId=" + placeCategoryId +
                ", placeCategoryName='" + placeCategoryName + '\'' +
                '}';
    }
}