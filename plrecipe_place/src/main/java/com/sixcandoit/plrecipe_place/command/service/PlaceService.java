package com.sixcandoit.plrecipe_place.command.service;

import com.sixcandoit.plrecipe_place.command.dto.CourseAndPlaceDTO;
import com.sixcandoit.plrecipe_place.command.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.command.dto.PlaceStarDTO;

public interface PlaceService {

    /* 장소 관련 */
    void registPlace(PlaceDTO newPlace);
    void deletePlace(int placeId);

    /* 코스 관련 */
    void registCourse(CourseAndPlaceDTO cp);
    void modifyCourse(CourseAndPlaceDTO cp);
    void deleteCourse(int courseId);

    /* 별점 관련 */
    void registStar(PlaceStarDTO newStar);
    void modifyStar(PlaceStarDTO modifyStar);
    void deleteStar(int starId);

}
