package com.sixcandoit.plrecipe_place.feature.place.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CoursePlaceDTO {
    private int courseId;
    private int placeId;
    private int sequence;

    public CoursePlaceDTO() {
    }
}