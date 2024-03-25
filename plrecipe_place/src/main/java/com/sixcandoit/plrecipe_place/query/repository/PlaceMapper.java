package com.sixcandoit.plrecipe_place.query.repository;

import com.sixcandoit.plrecipe_place.query.aggregate.Course;
import com.sixcandoit.plrecipe_place.query.aggregate.CourseAndPlace;
import com.sixcandoit.plrecipe_place.query.aggregate.Place;
import com.sixcandoit.plrecipe_place.query.aggregate.PlaceStar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlaceMapper {
    List<Place> selectAllPlace();
    Place selectPlaceById(int placeId);
    List<Place> selectPlaceByFilter(Map<String, Object> filter);
    List<Place> getPlacesByCourseName(int courseId);

    List<PlaceStar> selectStarByPlace(int placeId);
    List<PlaceStar> selectStarByMember(int memberId);

    List<Course> selectCourseByMember(int memberId);
    CourseAndPlace selectCoursePlaceByCourseId(int courseId);

    Float selectAvgStarScore(int placeId);
}
