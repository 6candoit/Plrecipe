package com.sixcandoit.plrecipe_place.query.controller;

import com.sixcandoit.plrecipe_place.query.dto.CourseAndPlaceDTO;
import com.sixcandoit.plrecipe_place.query.dto.CourseDTO;
import com.sixcandoit.plrecipe_place.query.dto.PlaceStarDTO;
import com.sixcandoit.plrecipe_place.query.dto.SearchPlaceDTO;
import com.sixcandoit.plrecipe_place.query.aggregate.Place;
import com.sixcandoit.plrecipe_place.query.service.PlaceService;
import com.sixcandoit.plrecipe_place.query.service.PlaceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class PlaceController {
    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceServiceImpl placeService) {
        this.placeService = placeService;
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


    // 설명. 별점 관련

    /* 장소별 별점 조회 */
    @GetMapping("star/{placeId}")
    public List<PlaceStarDTO> selectStarByPlace(@PathVariable int placeId){
        return placeService.selectStarByPlace(placeId);
    }

    /* 멤버별 별점 조회 */
    @GetMapping("star/member/{memberId}")
    public List<PlaceStarDTO> selectStarByMember(@PathVariable int memberId){
        return placeService.selectStarByMember(memberId);
    }


    /* 설명. 코스 관련 */

    /* 코스id로 코스와 코스에 등록된 장소 리스트 조회 */
    @GetMapping("/course/findInfo/{courseId}")
    public CourseAndPlaceDTO selectCoursePlaceByCourseId(@PathVariable int courseId){
        return placeService.selectCoursePlaceByCourseId(courseId);
    }

    /* 멤버id로 멤버가 생성한 코스 조회 */
    @GetMapping("/course/findUserId/{memberId}")
    List<CourseDTO> selectCourseByMember(@PathVariable int memberId){
        return placeService.selectCourseByMember(memberId);
    }

    /* 코스id로 장소만 불러오기 */
    @GetMapping("/course/findPlaces/{courseId}")
    List<Place> getPlacesByCourseName(@PathVariable int courseId){
        return placeService.getPlacesByCourseName(courseId);
    }

}
