package com.sixcandoit.plrecipe_place.query.service;

import com.sixcandoit.plrecipe_place.query.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.query.dto.PlaceStarDTO;
import com.sixcandoit.plrecipe_place.query.dto.SearchPlaceDTO;
import com.sixcandoit.plrecipe_place.query.aggregate.Place;
import com.sixcandoit.plrecipe_place.query.aggregate.PlaceStar;

import java.util.List;
import java.util.Map;

public interface PlaceService {
    List<SearchPlaceDTO> getSearchPlaceByAPI(String keyword);
    List<Place> selectAllPlace();

    List<Place> selectPlaceByFilter(Map<String, Object> filter);

    List<PlaceStar> selectStarByPlace(int placeId);

    List<PlaceStar> selectStarByMember(int memberId);
    List<Place> selectPlaceById(int placeId);

    void registPlace(PlaceDTO newPlace);

    void registStar(PlaceStarDTO newStar);

    void modifyStar(PlaceStarDTO modifyStar);

    void deletePlace(int placeId);

    void deleteStar(int starId);

}
