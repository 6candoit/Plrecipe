package com.sixcandoit.plrecipe_place.feature.place;

import com.netflix.discovery.converters.Auto;
import com.sixcandoit.plrecipe_place.feature.place.dto.CourseDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.entity.Course;
import com.sixcandoit.plrecipe_place.feature.place.entity.CourseAndPlace;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import com.sixcandoit.plrecipe_place.feature.place.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CourseAndPlaceServiceImplTests {
    private final CourseService courseService;

    @Autowired
    public CourseAndPlaceServiceImplTests(CourseService courseService) {
        this.courseService = courseService;
    }

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

        CourseAndPlace courseAndPlaceList = courseService.selectCoursePlaceByCourseId(courseId);
        //courseAndPlaceList.forEach(System.out::println);


        assertNotNull(courseAndPlaceList);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void selectCourseByMember(int memberId){
        List<Course> courseList = courseService.selectCourseByMember(memberId);
        courseList.forEach(System.out::println);

        assertNotNull(!courseList.isEmpty());
    }

    @Test
    void registCourse(){

        Course course = new Course("22코스생성테스트22", 6);
        List<Place> placeList = courseService.getPlacesByCourseName(1);
        CourseAndPlace cp = new CourseAndPlace(course, placeList);

        courseService.registCourse(cp);
    }

    @Test
    void modifyCourse(){

        Course course = courseService.selectCourseByMember(6).get(0);
        course.setCourseName("---코스수정테스트---");
        List<Place> placeList = courseService.getPlacesByCourseName(course.getCourseId());
        placeList.add(placeList.get(1));

        CourseAndPlace cp = new CourseAndPlace(course, placeList);

        courseService.modifyCourse(cp);
    }

    @Test
    void deleteCourse(){

        Course course = courseService.selectCourseByMember(6).get(0);

        courseService.deleteCourse(course.getCourseId());
    }



}
