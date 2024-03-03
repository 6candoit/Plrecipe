package com.sixcandoit.plrecipe_place.feature.place.repository;

import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import com.sixcandoit.plrecipe_place.feature.place.entity.PlaceStar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceStarRepository extends JpaRepository<PlaceStar, Integer> {
}
