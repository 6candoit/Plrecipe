package com.sixcandoit.plrecipe_place.feature.place.service;

import com.sixcandoit.plrecipe_place.feature.place.entity.Course;
import com.sixcandoit.plrecipe_place.feature.place.entity.CoursePlace;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;

import java.util.List;

public interface CourseService {
    List<CoursePlace> selectCoursePlaceByCourseId(int courseId);
    List<Course> selectCourseByMember(int memberId);
    List<Place> getPlacesByCourseName(int courseId);
}
