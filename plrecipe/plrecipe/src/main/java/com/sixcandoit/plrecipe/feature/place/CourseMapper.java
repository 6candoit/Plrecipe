package com.sixcandoit.plrecipe.feature.place;

import com.sixcandoit.plrecipe.feature.place.Place;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<PlaceDTO> getPlacesByCourseName(int courseId);
}
