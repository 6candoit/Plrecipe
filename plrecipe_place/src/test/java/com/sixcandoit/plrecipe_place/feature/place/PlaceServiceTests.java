package com.sixcandoit.plrecipe_place.feature.place;

import com.sixcandoit.plrecipe_place.PlrecipePlaceApplication;
import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceStarDTO;
import com.sixcandoit.plrecipe_place.feature.place.entity.*;
import com.sixcandoit.plrecipe_place.feature.place.service.PlaceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PlaceServiceTests {

    @Autowired
    private PlaceService placeService;

    @Test
    void findAllPlace() {
        List<Place> placeList = placeService.selectAllPlace();
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

        List<Place> placeList = placeService.selectPlaceByFilter(filter);
        placeList.forEach(System.out::println);
        System.out.println("--------------------------------------------");

        assertTrue(true);
    }




    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void findStarByPlace(int placeId){

        List<PlaceStar> placeList = placeService.selectStarByPlace(placeId);
        placeList.forEach(System.out::println);

        assertNotNull(!placeList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"park123@naver.com"})
    void selectCourseByMember(String memberEmail){
        List<Course> courseList = placeService.selectCourseByMember(memberEmail);
        courseList.forEach(System.out::println);

        assertNotNull(!courseList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"park123@naver.com"})
    void selectStarByMember(String memberEmail){
        List<PlaceStar> starList = placeService.selectStarByMember(memberEmail);
        starList.forEach(System.out::println);

        assertNotNull(!starList.isEmpty());
    }

    @Test
    void insertPlace(){
        PlaceDTO newPlace = new PlaceDTO("장소 insert 테스트", "서울시 도봉구", "0000", 3);
        placeService.registPlace(newPlace);
    }

    @Test
    void insertPlaceStar(){
        PlaceStarDTO newStar = new PlaceStarDTO(3, "insert 별점", 3, "f414mce3@yahoo.com");
        placeService.registStar(newStar);
    }

    @Test
    void modifyPlaceStar(){
        PlaceStarDTO modifyStar = new PlaceStarDTO(11,2, "modify 별점", 3, "f414mce3@yahoo.com");
        placeService.modifyStar(modifyStar);
    }

    @Test
    void deletePlace(){
        placeService.deletePlace(31);
    }

}
