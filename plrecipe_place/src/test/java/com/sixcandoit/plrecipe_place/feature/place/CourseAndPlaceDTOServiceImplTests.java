package com.sixcandoit.plrecipe_place.feature.place;


import com.sixcandoit.plrecipe_place.command.aggregate.Course;
import com.sixcandoit.plrecipe_place.command.dto.CourseAndPlaceDTO;
import com.sixcandoit.plrecipe_place.command.aggregate.Place;
import com.sixcandoit.plrecipe_place.command.service.PlaceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CourseAndPlaceDTOServiceImplTests {
    /*
    private final PlaceService placeService;

    @Autowired
    public CourseAndPlaceDTOServiceImplTests(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Test
    void getPlacesByCourseName() {
        int courseId = 1;

        List<Place> places = placeService.getPlacesByCourseName(courseId);

        assertNotNull(places);
        places.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void selectCoursePlaceByCourseId(int courseId){

        CourseAndPlaceDTO courseAndPlaceDTOList = placeService.selectCoursePlaceByCourseId(courseId);

        assertNotNull(courseAndPlaceDTOList);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void selectCourseByMember(int memberId){
        List<CourseDTO> courseList = placeService.selectCourseByMember(memberId);
        courseList.forEach(System.out::println);

        assertNotNull(!courseList.isEmpty());
    }

    @Test
    void registCourse(){

        Course course = new Course("22코스생성테스트22", 3);
        List<Place> placeList = placeService.getPlacesByCourseName(1);
        CourseAndPlaceDTO cp = new CourseAndPlaceDTO(course, placeList);

        placeService.registCourse(cp);
    }

    @Test
    void modifyCourse(){

        CourseDTO courseDTO = placeService.selectCourseByMember(3).get(0);
        Course modifyCourse = new Course(courseDTO.getCourseId(), courseDTO.getCourseName(), courseDTO.getMember().getMemberId());
        modifyCourse.setCourseName("---코스수정테스트---");
        List<Place> placeList = placeService.getPlacesByCourseName(modifyCourse.getCourseId());
        placeList.add(placeList.get(1));

        CourseAndPlaceDTO cp = new CourseAndPlaceDTO(modifyCourse, placeList);

        placeService.modifyCourse(cp);
    }

    @Test
    void deleteCourse(){

        CourseDTO course = placeService.selectCourseByMember(3).get(0);

        placeService.deleteCourse(course.getCourseId());
    }
*/


}
