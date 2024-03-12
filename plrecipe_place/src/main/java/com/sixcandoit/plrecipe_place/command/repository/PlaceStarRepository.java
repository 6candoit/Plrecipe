package com.sixcandoit.plrecipe_place.command.repository;

import com.sixcandoit.plrecipe_place.command.aggregate.PlaceStar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceStarRepository extends JpaRepository<PlaceStar, Integer> {
}
