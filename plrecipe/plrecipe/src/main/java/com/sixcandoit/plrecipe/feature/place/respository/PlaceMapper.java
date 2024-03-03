package com.sixcandoit.plrecipe.feature.place.respository;

import com.sixcandoit.plrecipe.feature.place.dto.CourseDTO;
import com.sixcandoit.plrecipe.feature.place.dto.PlaceDTO;
import com.sixcandoit.plrecipe.feature.place.dto.PlaceStarDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlaceMapper {
    List<PlaceDTO> selectAllPlace();

    List<PlaceDTO> selectPlaceByFilter(Map<String, Object> filter);

    List<PlaceStarDTO> selectStarByPlace(int placeId);

    List<CourseDTO> selectCourseByMember(String memberEmail);

    List<PlaceStarDTO> selectStarByMember(String memberEmail);
}
