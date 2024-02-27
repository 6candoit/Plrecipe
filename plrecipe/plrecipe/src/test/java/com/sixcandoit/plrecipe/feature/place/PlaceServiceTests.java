package com.sixcandoit.plrecipe.feature.place;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PlaceServiceTests {

    @Autowired
    private Place placeService;

    @Test
    void testRegistNewOrder() {

        List<PlaceDTO> place = placeService.selectAllPlace();
        place.forEach(System.out::println);

        assertNotNull(place);
    }

}
