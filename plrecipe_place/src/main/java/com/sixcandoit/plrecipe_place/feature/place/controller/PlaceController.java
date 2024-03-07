package com.sixcandoit.plrecipe_place.feature.place.controller;

import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceStarDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.SearchPlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.entity.Course;
import com.sixcandoit.plrecipe_place.feature.place.entity.CourseAndPlace;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import com.sixcandoit.plrecipe_place.feature.place.entity.PlaceStar;
import com.sixcandoit.plrecipe_place.feature.place.service.CourseService;
import com.sixcandoit.plrecipe_place.feature.place.service.PlaceService;
import com.sixcandoit.plrecipe_place.feature.place.service.PlaceServiceImpl;
import jakarta.ws.rs.DELETE;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Fetch;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@Slf4j
public class PlaceController {
    private final PlaceService placeService;
    private final CourseService courseService;

    @Autowired
    public PlaceController(PlaceServiceImpl placeService, CourseService courseService) {
        this.placeService = placeService;
        this.courseService = courseService;
    }

    /* 설명. 장소 관련 */

    /* 장소 추가를 위해 키워드로 장소 검색해서 초기 장소 리스트 받아오기 - searchPlaceDTO (등록할 장소 검색) */
    @GetMapping("/findBasePlace/{keyword}")
    public List<SearchPlaceDTO> findBasePlace(@PathVariable String keyword) {
        return placeService.getSearchPlaceByAPI(keyword);
    }

    /* 장소 불러오기 */
    @GetMapping(value = {"/find/{placeId}", "/find"})
    public List<Place> findPlace(@PathVariable(required = false) String placeId){
        if(placeId == null)
            return placeService.selectAllPlace();
        else
            return placeService.selectPlaceById(Integer.valueOf(placeId));
    }

    /* 조건에 따라 장소 검색 */
    @PostMapping("/searchPlace")
    public List<Place> selectPlaceByFilter(@RequestBody Map<String, Object> filter){
        return placeService.selectPlaceByFilter(filter);
    }

    /* 장소 등록 */
    @PostMapping("/regist")
    public ResponseEntity<PlaceDTO> registPlace(@RequestBody PlaceDTO newPlace){
        System.out.println("newPlace = " + newPlace);
        placeService.registPlace(newPlace);

       return ResponseEntity.status(HttpStatus.CREATED).body(newPlace);
    }

    /* 장소 삭제 */
    @DeleteMapping("/delete/{placeId}")
    public ResponseEntity<?> deletePlace(@PathVariable int placeId){

        placeService.deletePlace(placeId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }


    // 설명. 별점 관련

    /* 장소별 별점 조회 */
    @GetMapping("star/{placeId}")
    public List<PlaceStar> selectStarByPlace(@PathVariable int placeId){
        return placeService.selectStarByPlace(placeId);
    }

    /* 멤버별 별점 조회 */
    @GetMapping("star/member/{memberId}")
    public List<PlaceStar> selectStarByMember(@PathVariable int memberId){
        return placeService.selectStarByMember(memberId);
    }

    /* 별점 등록 */
    @PostMapping("star/regist")
    public ResponseEntity<PlaceStarDTO> registStar(@RequestBody PlaceStarDTO newPlaceStar){

        placeService.registStar(newPlaceStar);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPlaceStar);
    }

    /* 별점 수정 */
    @PatchMapping ("star/modify")
    public ResponseEntity<PlaceStarDTO> modifyStar(@RequestBody PlaceStarDTO modifyPlaceStar){

        placeService.modifyStar(modifyPlaceStar);

        return ResponseEntity.status(HttpStatus.OK).body(modifyPlaceStar);
    }

    /* 별점 삭제 */
    @DeleteMapping("/star/delete/{starId}")
    public ResponseEntity<?> deleteStar(@PathVariable int starId){

        placeService.deleteStar(starId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /* 설명. 코스 관련 */

    /* 설명. 코스플레이스 리스트로 받아와져서 -> 하나의 객체에 1코스 n장소로 다시 바꿔야 함 */
    /* 코스id로 코스와 코스에 등록된 장소 리스트 조회 */
    @GetMapping("/course/findInfo/{courseId}")
    public CourseAndPlace selectCoursePlaceByCourseId(@PathVariable int courseId){
        return courseService.selectCoursePlaceByCourseId(courseId);
    }

    /* 멤버id로 멤버가 생성한 코스 조회 */
    @GetMapping("/course/findUserId/{memberId}")
    List<Course> selectCourseByMember(@PathVariable int memberId){
        return courseService.selectCourseByMember(memberId);
    }

    /* 코스id로 장소만 불러오기 */
    @GetMapping("/course/findPlaces/{courseId}")
    List<Place> getPlacesByCourseName(@PathVariable int courseId){
        return courseService.getPlacesByCourseName(courseId);
    }

    /* 코스 등록 */
    @PostMapping("/course/regist")
    public ResponseEntity<?> registCourse(@RequestBody CourseAndPlace newCoursePlace){

        courseService.registCourse(newCoursePlace);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCoursePlace);
    }

    /* 코스 수정 */
    @PatchMapping ("course/modify")
    public ResponseEntity<?> modifyCourse(@RequestBody CourseAndPlace modifyCoursePlace){

        courseService.modifyCourse(modifyCoursePlace);

        return ResponseEntity.status(HttpStatus.OK).body(modifyCoursePlace);
    }

    /* 코스 삭제 */
    @DeleteMapping("/course/delete/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int courseId){

        courseService.deleteCourse(courseId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
