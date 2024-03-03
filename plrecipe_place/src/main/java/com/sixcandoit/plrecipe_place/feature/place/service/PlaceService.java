package com.sixcandoit.plrecipe_place.feature.place.service;

import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceStarDTO;
import com.sixcandoit.plrecipe_place.feature.place.entity.Course;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import com.sixcandoit.plrecipe_place.feature.place.entity.PlaceStar;
import com.sixcandoit.plrecipe_place.feature.place.repository.CourseMapper;
import com.sixcandoit.plrecipe_place.feature.place.repository.PlaceMapper;
import com.sixcandoit.plrecipe_place.feature.place.repository.PlaceRepository;
import com.sixcandoit.plrecipe_place.feature.place.repository.PlaceStarRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PlaceService {

    private final ModelMapper mapper;
    private final PlaceRepository placeRepository;
    private final PlaceStarRepository placeStarRepository;
    private final PlaceMapper placeMapper;
    private final CourseMapper courseMapper;

    @Autowired
    public PlaceService(ModelMapper mapper, PlaceRepository placeRepository, PlaceStarRepository placeStarRepository, PlaceMapper placeMapper, CourseMapper courseMapper) {
        this.mapper = mapper;
        this.placeRepository = placeRepository;
        this.placeStarRepository = placeStarRepository;
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


    public void registPlace(PlaceDTO newPlace) {
        placeRepository.save(mapper.map(newPlace, Place.class));
    }

    public void registStar(PlaceStarDTO newStar) {
        placeStarRepository.save(mapper.map(newStar, PlaceStar.class));
    }

    @Transactional
    public void modifyStar(PlaceStarDTO modifyStar) {
        PlaceStar foundStar = placeStarRepository.findById(modifyStar.getStarId()).orElseThrow(IllegalArgumentException::new);
        foundStar.setStarPoint(modifyStar.getStarPoint());
        foundStar.setStarComment(modifyStar.getStarComment());
    }

    @Transactional
    public void deletePlace(int placeId) {
        placeRepository.deleteById(placeId);
    }
}
