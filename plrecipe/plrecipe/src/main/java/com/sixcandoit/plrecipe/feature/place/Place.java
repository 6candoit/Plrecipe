package com.sixcandoit.plrecipe.feature.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Place {
    private PlaceMapper placeMapper;
    @Autowired
    public Place(PlaceMapper placeMapper) {
        this.placeMapper = placeMapper;
    }
    public List<PlaceDTO> selectAllPlace() {
        return placeMapper.selectAllPlace();
    }
    public List<PlaceDTO> selectPlaceByCategory(String categoryName) { return placeMapper.selectPlaceByCategory(categoryName);}
    public List<PlaceStarDTO> selectStarByPlace(int placeId) { return placeMapper.selectStarByPlace(placeId);}



}
