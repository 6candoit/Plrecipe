package com.sixcandoit.plrecipe_place.feature.place.dto;

import com.sixcandoit.plrecipe_place.feature.place.vo.ResponseMember;
import lombok.Data;

@Data
public class CourseDTO {
    private int courseId;
    private String courseName;

    private ResponseMember member;

    public CourseDTO() {
    }


}
