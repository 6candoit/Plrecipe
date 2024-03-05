package com.sixcandoit.plrecipe_place.feature.place.service;

import com.sixcandoit.plrecipe_place.feature.place.dto.CourseDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.entity.Course;
import com.sixcandoit.plrecipe_place.feature.place.entity.CourseAndPlace;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;

import java.util.List;

public interface CourseService {
    List<CourseAndPlace> selectCoursePlaceByCourseId(int courseId);
    List<Course> selectCourseByMember(int memberId);
    List<Place> getPlacesByCourseName(int courseId);

    void registCoursePlace(CourseDTO course, List<PlaceDTO> placeList);
}
