package com.sixcandoit.plrecipe.feature.place;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PlaceServiceTests {

    @Autowired
    private Place placeService;

    @Test
    void findAllPlace() {
        List<PlaceDTO> placeList = placeService.selectAllPlace();
        placeList.forEach(System.out::println);

        assertTrue(!placeList.isEmpty());
    }


    static Stream<Map<String, Object>> getParams() {
        return Stream.of(
                createParams("붕어", null, null, null),
                createParams(null, "서울", null, 2),
                createParams(null, "창원", null, null),
                createParams(null, "제주", "산책", null)
        );
    }

    private static HashMap<String, Object> createParams(Object name, Object region, Object category, Object star) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("region", region);
        params.put("category", category);
        params.put("star", star);
        return params;
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void findPlaceByFilter(Map<String, Object> filter){

        List<PlaceDTO> placeList = placeService.selectPlaceByFilter(filter);
        placeList.forEach(System.out::println);
        System.out.println("--------------------------------------------");

        assertTrue(true);
    }




    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void findStarByPlace(int placeId){

        List<PlaceStarDTO> placeList = placeService.selectStarByPlace(placeId);
        placeList.forEach(System.out::println);

        assertNotNull(!placeList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"park123@naver.com"})
    void selectCourseByMember(String memberEmail){
        List<CourseDTO> courseList = placeService.selectCourseByMember(memberEmail);
        courseList.forEach(System.out::println);

        assertNotNull(!courseList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"park123@naver.com"})
    void selectStarByMember(String memberEmail){
        List<PlaceStarDTO> starList = placeService.selectStarByMember(memberEmail);
        starList.forEach(System.out::println);

        assertNotNull(!starList.isEmpty());
    }
}
