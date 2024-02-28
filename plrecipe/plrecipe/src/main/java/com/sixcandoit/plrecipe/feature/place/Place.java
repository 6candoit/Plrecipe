package com.sixcandoit.plrecipe.feature.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<PlaceDTO> selectPlaceByFilter(Map<String, Object> filter) { return placeMapper.selectPlaceByFilter(filter);}
    public List<PlaceStarDTO> selectStarByPlace(int placeId) { return placeMapper.selectStarByPlace(placeId);}

    public List<CourseDTO> selectCourseByMember(String memberEmail){
        return placeMapper.selectCourseByMember(memberEmail);
    }

    public List<PlaceStarDTO> selectStarByMember(String memberEmail){
        return placeMapper.selectStarByMember(memberEmail);
    }

}
