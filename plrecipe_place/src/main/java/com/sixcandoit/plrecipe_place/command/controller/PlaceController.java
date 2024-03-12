package com.sixcandoit.plrecipe_place.command.controller;

import com.sixcandoit.plrecipe_place.command.dto.CourseAndPlaceDTO;
import com.sixcandoit.plrecipe_place.command.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.command.dto.PlaceStarDTO;
import com.sixcandoit.plrecipe_place.command.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PlaceController {
    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    /* 설명. 장소 관련 */

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

    /* 코스 등록 */
    @PostMapping("/course/regist")
    public ResponseEntity<?> registCourse(@RequestBody CourseAndPlaceDTO newCoursePlace){

        placeService.registCourse(newCoursePlace);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCoursePlace);
    }

    /* 코스 수정 */
    @PatchMapping ("/course/modify")
    public ResponseEntity<?> modifyCourse(@RequestBody CourseAndPlaceDTO modifyCoursePlace){

        placeService.modifyCourse(modifyCoursePlace);

        return ResponseEntity.status(HttpStatus.OK).body(modifyCoursePlace);
    }

    /* 코스 삭제 */
    @DeleteMapping("/course/delete/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int courseId){

        placeService.deleteCourse(courseId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
