package com.sixcandoit.plrecipe_place.query.repository;

import com.sixcandoit.plrecipe_place.query.aggregate.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
