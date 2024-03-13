package com.sixcandoit.plrecipe_place.command.repository;

import com.sixcandoit.plrecipe_place.command.aggregate.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
