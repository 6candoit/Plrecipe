package com.sixcandoit.plrecipe_place.feature.place.service;

import com.sixcandoit.plrecipe_place.feature.place.entity.Course;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import com.sixcandoit.plrecipe_place.feature.place.entity.PlaceStar;
import com.sixcandoit.plrecipe_place.feature.place.repository.CourseMapper;
import com.sixcandoit.plrecipe_place.feature.place.repository.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlaceService {

    private final PlaceMapper placeMapper;
    private final CourseMapper courseMapper;

    @Autowired
    public PlaceService(PlaceMapper placeMapper, CourseMapper courseMapper) {
        this.placeMapper = placeMapper;
        this.courseMapper = courseMapper;
    }

    public List<Place> selectAllPlace() {
        return placeMapper.selectAllPlace();
    }

    public List<Place> selectPlaceByFilter(Map<String, Object> filter) { return placeMapper.selectPlaceByFilter(filter);}
    public List<PlaceStar> selectStarByPlace(int placeId) { return placeMapper.selectStarByPlace(placeId);}


    public List<Place> getPlacesByCourseName(int courseId){ return courseMapper.getPlacesByCourseName(courseId);}

    public List<Course> selectCourseByMember(String memberEmail){
        return placeMapper.selectCourseByMember(memberEmail);
    }

    public List<PlaceStar> selectStarByMember(String memberEmail){
        return placeMapper.selectStarByMember(memberEmail);
    }

}
