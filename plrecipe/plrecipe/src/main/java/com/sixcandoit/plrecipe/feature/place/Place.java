package com.sixcandoit.plrecipe.feature.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<PlaceDTO> selectPlaceByCategory(String categoryName) { return placeMapper.selectPlaceByCategory(categoryName);}
    public List<PlaceStarDTO> selectStarByPlace(int placeId) { return placeMapper.selectStarByPlace(placeId);}

    public List<PlaceDTO> getPlacesByCourseName(int courseId){ return courseMapper.getPlacesByCourseName(courseId);}


}
