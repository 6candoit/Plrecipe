package com.sixcandoit.plrecipe_place.feature.place;

import com.sixcandoit.plrecipe_place.feature.place.entity.Course;
import com.sixcandoit.plrecipe_place.feature.place.entity.CoursePlace;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import com.sixcandoit.plrecipe_place.feature.place.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CoursePlaceServiceImplTests {

    @Autowired
    private CourseService courseService;

    @Test
    void getPlacesByCourseName() {
        int courseId = 1;

        List<Place> places = courseService.getPlacesByCourseName(courseId);

        assertNotNull(places);
        places.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void selectCoursePlaceByCourseId(int courseId){

        List<CoursePlace> coursePlaceList = courseService.selectCoursePlaceByCourseId(courseId);
        coursePlaceList.forEach(System.out::println);

        assertNotNull(!coursePlaceList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void selectCourseByMember(int memberId){
        List<Course> courseList = courseService.selectCourseByMember(memberId);
        courseList.forEach(System.out::println);

        assertNotNull(!courseList.isEmpty());
    }
}
