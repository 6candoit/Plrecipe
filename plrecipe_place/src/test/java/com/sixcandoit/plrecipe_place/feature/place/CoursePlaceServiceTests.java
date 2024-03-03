package com.sixcandoit.plrecipe_place.feature.place;

import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import com.sixcandoit.plrecipe_place.feature.place.service.PlaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CoursePlaceServiceTests {

    @Autowired
    private PlaceService placeService;

    @Test
    void getPlacesByCourseName() {
        int courseId = 1;

        List<Place> places = placeService.getPlacesByCourseName(courseId);

        assertNotNull(places);
        places.forEach(System.out::println);
    }
}
