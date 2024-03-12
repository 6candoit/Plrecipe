package com.sixcandoit.plrecipe_place.query.repository;

import com.sixcandoit.plrecipe_place.query.aggregate.Course;
import com.sixcandoit.plrecipe_place.query.aggregate.CourseAndPlace;
import com.sixcandoit.plrecipe_place.query.aggregate.Place;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Place> getPlacesByCourseName(int courseId);
    List<Course> selectCourseByMember(int memberId);
    CourseAndPlace selectCoursePlaceByCourseId(int courseId);
}
