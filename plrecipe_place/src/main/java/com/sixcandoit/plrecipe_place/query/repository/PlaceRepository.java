package com.sixcandoit.plrecipe_place.query.repository;

import com.sixcandoit.plrecipe_place.query.aggregate.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
