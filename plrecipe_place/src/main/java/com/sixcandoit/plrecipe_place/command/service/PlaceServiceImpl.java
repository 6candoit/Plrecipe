package com.sixcandoit.plrecipe_place.command.service;

import com.sixcandoit.plrecipe_place.command.aggregate.*;
import com.sixcandoit.plrecipe_place.command.dto.CourseAndPlaceDTO;
import com.sixcandoit.plrecipe_place.command.dto.CoursePlaceDTO;
import com.sixcandoit.plrecipe_place.command.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.command.dto.PlaceStarDTO;
import com.sixcandoit.plrecipe_place.command.repository.CoursePlaceRepository;
import com.sixcandoit.plrecipe_place.command.repository.CourseRepository;
import com.sixcandoit.plrecipe_place.command.repository.PlaceRepository;
import com.sixcandoit.plrecipe_place.command.repository.PlaceStarRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final ModelMapper mapper;
    private final PlaceRepository placeRepository;
    private final CourseRepository courseRepository;
    private final CoursePlaceRepository coursePlaceRepository;
    private final PlaceStarRepository placeStarRepository;


    public PlaceServiceImpl(ModelMapper mapper, PlaceRepository placeRepository, CourseRepository courseRepository, CoursePlaceRepository coursePlaceRepository, PlaceStarRepository placeStarRepository) {
        this.mapper = mapper;
        this.placeRepository = placeRepository;
        this.courseRepository = courseRepository;
        this.coursePlaceRepository = coursePlaceRepository;
        this.placeStarRepository = placeStarRepository;
    }

    /* 설명. 장소 관련 */

    /* 장소 insert */
    @Transactional
    public void registPlace(PlaceDTO newPlace) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        placeRepository.save(mapper.map(newPlace, Place.class));
    }

    /* 장소 delete */
    @Transactional
    public void deletePlace(int placeId) {
        coursePlaceRepository.deleteAllByPlaceId(placeId);
        placeRepository.deleteById(placeId);
    }

    /* 설명. 코스 관련 */

    /* 코스 insert */
    @Transactional
    public void registCourse(CourseAndPlaceDTO cp) {

        /* 코스 정보 insert */
        Course newCourse = new Course(cp.getCourseName(), cp.getMemberId());
        courseRepository.save(newCourse);

        /* 코스장소 정보 insert */
        saveCoursePlace(newCourse.getCourseId(), cp.getPlaces());
    }

    /* 코스장소(중간테이블)에 정보 insert */
    @Transactional
    public void saveCoursePlace(int courseId, List<Place> placeList){

        /* 코스id와 장소id를 중간객체 리스트로 만들어서 저장 */
        List<CoursePlaceDTO> coursePlaceList = new ArrayList<>();
        for (int i = 0; i < placeList.size(); i++) {
            CoursePlaceDTO coursePlaceDTO = new CoursePlaceDTO(courseId, placeList.get(i).getPlaceId(), i+1);
            coursePlaceList.add(coursePlaceDTO);
        }

        /* 코스장소 정보 저장 */
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CoursePlace> coursePlaces = coursePlaceList.stream()
                .map(coursePlace -> mapper.map(coursePlace, CoursePlace.class))
                .collect(Collectors.toList());
        coursePlaceRepository.saveAll(coursePlaces);

    }

    /* 코스 정보 수정 */
    @Transactional
    public void modifyCourse(CourseAndPlaceDTO modifyCP) {

        int courseId = modifyCP.getCourseId();
        Course foundCourse = courseRepository.findById(courseId).orElseThrow(IllegalArgumentException::new);
        foundCourse.setCourseName(modifyCP.getCourseName());

        deleteCoursePlace(courseId);
        saveCoursePlace(courseId, modifyCP.getPlaces());

    }

    /* 코스 삭제 */
    @Transactional
    public void deleteCourse(int courseId) {

        deleteCoursePlace(courseId);
        courseRepository.deleteById(courseId);

    }

    /* 코스장소 삭제 */
    @Transactional
    public void deleteCoursePlace(int courseId){
        coursePlaceRepository.deleteAllByCourseId(courseId);
    }

    /* 설명. 별점 관련 */

    /* 별점 insert */
    @Transactional
    public void registStar(PlaceStarDTO newStar) {
        placeStarRepository.save(mapper.map(newStar, PlaceStar.class));
    }

    /* 별점 modify */
    @Transactional
    public void modifyStar(PlaceStarDTO modifyStar) {
        PlaceStar foundStar = placeStarRepository.findById(modifyStar.getStarId()).orElseThrow(IllegalArgumentException::new);
        foundStar.setStarPoint(modifyStar.getStarPoint());
        foundStar.setStarComment(modifyStar.getStarComment());
    }

    /* 별점 delete */
    @Transactional
    public void deleteStar(int starId) {
        placeStarRepository.deleteById(starId);
    }

}
