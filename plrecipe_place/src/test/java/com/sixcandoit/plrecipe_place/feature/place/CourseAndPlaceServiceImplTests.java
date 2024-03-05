package com.sixcandoit.plrecipe_place.feature.place;

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

        List<CourseAndPlace> courseAndPlaceList = courseService.selectCoursePlaceByCourseId(courseId);
        courseAndPlaceList.forEach(System.out::println);

        assertNotNull(!courseAndPlaceList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void selectCourseByMember(int memberId){
        List<Course> courseList = courseService.selectCourseByMember(memberId);
        courseList.forEach(System.out::println);

        assertNotNull(!courseList.isEmpty());
    }

    @Test
    void insertCoursePlace(){
        CourseDTO course = new CourseDTO("코스생성", 2);
        List<PlaceDTO> placeList = new ArrayList<>();
        placeList.add(new PlaceDTO("테스트 장소1", "경기도 고양시", "031-0000-0000", 3));
        placeList.add(new PlaceDTO("테스트 장소2", "서울22", "01-0000-0000", 4));
        placeList.add(new PlaceDTO("테스트 장소3", "광명22", "02-0000-0000", 5));
        placeList.add(new PlaceDTO("테스트 장소4", "강서22", "03-0000-0000", 6));

        courseService.registCoursePlace(course, placeList);

    }

}
