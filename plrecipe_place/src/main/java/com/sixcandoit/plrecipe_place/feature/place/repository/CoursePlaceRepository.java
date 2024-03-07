package com.sixcandoit.plrecipe_place.feature.place.repository;

import com.sixcandoit.plrecipe_place.feature.place.entity.CoursePlace;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CoursePlaceRepository extends JpaRepository<CoursePlace, Integer> {

    @Modifying
    @Query("delete from plrecipe_course_and_place A where A.courseId = :courseId")
    void deleteAllByCourseId(@Param("courseId") int courseId);

    @Modifying
    @Query("delete from plrecipe_course_and_place A where A.placeId = :placeId")
    void deleteAllByPlaceId(int placeId);
}
