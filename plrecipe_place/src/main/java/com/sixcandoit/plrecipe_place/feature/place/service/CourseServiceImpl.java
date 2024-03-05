package com.sixcandoit.plrecipe_place.feature.place.service;

import com.sixcandoit.plrecipe_place.feature.place.dto.CourseDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.CoursePlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.entity.Course;
import com.sixcandoit.plrecipe_place.feature.place.entity.CourseAndPlace;
import com.sixcandoit.plrecipe_place.feature.place.entity.CoursePlace;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import com.sixcandoit.plrecipe_place.feature.place.repository.CourseMapper;
import com.sixcandoit.plrecipe_place.feature.place.repository.CoursePlaceRepository;
import com.sixcandoit.plrecipe_place.feature.place.repository.CourseRepository;
import com.sixcandoit.plrecipe_place.feature.place.repository.PlaceRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;
    private final ModelMapper mapper;
    private final CourseRepository courseRepository;
    private final PlaceRepository placeRepository;
    private final CoursePlaceRepository coursePlaceRepository;


    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper, ModelMapper mapper, CourseRepository courseRepository, PlaceRepository placeRepository, CoursePlaceRepository coursePlaceRepository) {
        this.courseMapper = courseMapper;
        this.mapper = mapper;
        this.courseRepository = courseRepository;
        this.placeRepository = placeRepository;
        this.coursePlaceRepository = coursePlaceRepository;
    }

    /* 코스id로 한 코스의 정보와 코스에 해당하는 장소 리스트 select (CoursePlace) */
    public List<CourseAndPlace> selectCoursePlaceByCourseId(int courseId){
        return courseMapper.selectCoursePlaceByCourseId(courseId);
    }

    /* 코스id에 해당하는 장소 리스트 select */
    public List<Place> getPlacesByCourseName(int courseId){ return courseMapper.getPlacesByCourseName(courseId);}


    @Override
    public void registCoursePlace(CourseDTO course, List<PlaceDTO> placeList) {

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        /* 코스 정보 저장 */
        Course newCourse = mapper.map(course, Course.class);
        courseRepository.save(newCourse);
        System.out.println("newCourse = " + newCourse);

        /* 장소 정보 저장 */
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<Place> places = placeList.stream().map(place -> mapper.map(place, Place.class)).collect(Collectors.toList());
        System.out.println("places = " + places);
        placeRepository.saveAll(places);

//        /* 코스id와 장소id를 중간객체 리스트로 만들어서 저장 */
//        List<CoursePlaceDTO> coursePlaceList = new ArrayList<>();
//        for (int i = 0; i < placeList.size(); i++) {
//            CoursePlaceDTO coursePlaceDTO = new CoursePlaceDTO(newCourse.getCourseId(), places.get(i).getPlaceId(), i);
//            coursePlaceList.add(coursePlaceDTO);
//        }
//
//        /* 코스장소 정보 저장 */
//        List<CoursePlace> coursePlaces = coursePlaceList.stream()
//                .map(coursePlace -> mapper.map(coursePlace, CoursePlace.class))
//                .collect(Collectors.toList());
//        coursePlaceRepository.saveAll(coursePlaces);
    }

    /* 멤버id로 멤버가 작성한 코스 리스트 select */
    public List<Course> selectCourseByMember(int memberId){
        return courseMapper.selectCourseByMember(memberId);
    }
}
