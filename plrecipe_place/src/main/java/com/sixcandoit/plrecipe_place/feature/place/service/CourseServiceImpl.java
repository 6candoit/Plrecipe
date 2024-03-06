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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;
    private final ModelMapper mapper;
    private final CourseRepository courseRepository;
    private final CoursePlaceRepository coursePlaceRepository;


    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper, ModelMapper mapper, CourseRepository courseRepository, CoursePlaceRepository coursePlaceRepository) {
        this.courseMapper = courseMapper;
        this.mapper = mapper;
        this.courseRepository = courseRepository;
        this.coursePlaceRepository = coursePlaceRepository;
    }

    /* 멤버id로 멤버가 작성한 코스 리스트 select */
    public List<Course> selectCourseByMember(int memberId){
        return courseMapper.selectCourseByMember(memberId);
    }

    /* 코스id로 한 코스의 정보와 코스에 해당하는 장소 리스트 select (CoursePlace) */
    public List<CourseAndPlace> selectCoursePlaceByCourseId(int courseId){
        return courseMapper.selectCoursePlaceByCourseId(courseId);
    }

    /* 코스id에 해당하는 장소 리스트 select */
    public List<Place> getPlacesByCourseName(int courseId){
        return courseMapper.getPlacesByCourseName(courseId);
    }

    /* 코스 insert */
    @Override
    public void registCourse(CourseAndPlace cp) {

        /* 코스 정보 insert */
        Course newCourse = cp.getCourse();
        courseRepository.save(newCourse);

        /* 코스장소 정보 insert */
        saveCoursePlace(newCourse.getCourseId(), cp.getPlaces());
    }

    /* 코스장소(중간테이블)에 정보 insert */
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
    public void modifyCourse(CourseAndPlace modifyCP) {

        int courseId = modifyCP.getCourse().getCourseId();
        Course foundCourse = courseRepository.findById(courseId).orElseThrow(IllegalArgumentException::new);
        foundCourse.setCourseName(modifyCP.getCourse().getCourseName());

        deleteCoursePlace(courseId);
        saveCoursePlace(courseId, modifyCP.getPlaces());

    }

    /* 코스장소 삭제 */
    @Transactional
    public void deleteCoursePlace(int courseId){
        coursePlaceRepository.deleteAllByCourseId(courseId);
    }

    /* 코스 삭제 */
    @Transactional
    public void deleteCourse(CourseAndPlace deleteCP) {

        int courseId = deleteCP.getCourse().getCourseId();
        deleteCoursePlace(courseId);
        courseRepository.deleteById(courseId);

    }

}
