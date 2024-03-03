package com.sixcandoit.plrecipe.feature.place;

import com.sixcandoit.plrecipe.feature.place.dto.PlaceDTO;
import com.sixcandoit.plrecipe.feature.place.entity.Place;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CoursePlaceServiceTests {

    @Autowired
    private Place placeService;

    @Test
    void getPlacesByCourseName() {
        int courseId = 1;

        List<PlaceDTO> places = placeService.getPlacesByCourseName(courseId);

        assertNotNull(places);
        places.forEach(System.out::println);
    }
}
