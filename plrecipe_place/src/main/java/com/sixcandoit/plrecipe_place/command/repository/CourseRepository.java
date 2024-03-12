package com.sixcandoit.plrecipe_place.command.repository;

import com.sixcandoit.plrecipe_place.command.aggregate.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
