package com.sixcandoit.plrecipe_place.query.repository;

import com.sixcandoit.plrecipe_place.query.aggregate.PlaceStar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceStarRepository extends JpaRepository<PlaceStar, Integer> {
}
