package com.sixcandoit.plrecipe.feature.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Place {

    private final PlaceMapper placeMapper;
    private final CourseMapper courseMapper;

    @Autowired
    public Place(PlaceMapper placeMapper, CourseMapper courseMapper) {
        this.placeMapper = placeMapper;
        this.courseMapper = courseMapper;
    }

    public List<PlaceDTO> selectAllPlace() {
        return placeMapper.selectAllPlace();
    }

    public List<PlaceDTO> selectPlaceByFilter(Map<String, Object> filter) { return placeMapper.selectPlaceByFilter(filter);}
    public List<PlaceStarDTO> selectStarByPlace(int placeId) { return placeMapper.selectStarByPlace(placeId);}


    public List<PlaceDTO> getPlacesByCourseName(int courseId){ return courseMapper.getPlacesByCourseName(courseId);}

    public List<CourseDTO> selectCourseByMember(String memberEmail){
        return placeMapper.selectCourseByMember(memberEmail);
    }

    public List<PlaceStarDTO> selectStarByMember(String memberEmail){
        return placeMapper.selectStarByMember(memberEmail);
    }

}
