package com.sixcandoit.plrecipe.feature.place.respository;

import com.sixcandoit.plrecipe.feature.place.dto.PlaceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<PlaceDTO> getPlacesByCourseName(int courseId);
}
