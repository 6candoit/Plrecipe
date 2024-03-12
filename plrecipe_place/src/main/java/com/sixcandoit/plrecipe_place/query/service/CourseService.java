package com.sixcandoit.plrecipe_place.query.service;

import com.sixcandoit.plrecipe_place.query.dto.CourseDTO;
import com.sixcandoit.plrecipe_place.query.aggregate.CourseAndPlace;
import com.sixcandoit.plrecipe_place.query.aggregate.Place;

import java.util.List;

public interface CourseService {
    CourseAndPlace selectCoursePlaceByCourseId(int courseId);
    List<CourseDTO> selectCourseByMember(int memberId);
    List<Place> getPlacesByCourseName(int courseId);

    void registCourse(CourseAndPlace cp);
    void modifyCourse(CourseAndPlace cp);

    void deleteCourse(int courseId);
}
