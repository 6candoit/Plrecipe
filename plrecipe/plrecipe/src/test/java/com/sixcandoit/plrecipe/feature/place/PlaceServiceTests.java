package com.sixcandoit.plrecipe.feature.place;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @ParameterizedTest
    @ValueSource(strings = {"음식점","카페", "문화", "액티비티", "산책", "기타"})
    void findPlaceByCategory(String categoryName){

        List<PlaceDTO> placeList = placeService.selectPlaceByCategory(categoryName);
        placeList.forEach(System.out::println);

        assertTrue(!placeList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void findStarByPlace(int placeId){

        List<PlaceStarDTO> placeList = placeService.selectStarByPlace(placeId);
        placeList.forEach(System.out::println);

        assertNotNull(!placeList.isEmpty());
    }
}
