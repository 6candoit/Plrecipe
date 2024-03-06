package com.sixcandoit.plrecipe_place.feature.place.repository;

import com.sixcandoit.plrecipe_place.feature.place.entity.Course;
import com.sixcandoit.plrecipe_place.feature.place.entity.CourseAndPlace;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Place> getPlacesByCourseName(int courseId);
    List<Course> selectCourseByMember(int memberId);
    CourseAndPlace selectCoursePlaceByCourseId(int courseId);
}
