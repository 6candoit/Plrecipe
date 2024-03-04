package com.sixcandoit.plrecipe_place.feature.place.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class CoursePlace {

    @Id
    @Column(name = "place_course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeCourseId;

    @Column (name = "place_id")
    private int placeId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course courseId;

    @Column(name = "place_sequence")
    private int placeSequence;

}
