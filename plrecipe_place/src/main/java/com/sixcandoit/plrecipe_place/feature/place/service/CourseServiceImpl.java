package com.sixcandoit.plrecipe_place.feature.place.service;

import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceStarDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.SearchPlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.entity.Course;
import com.sixcandoit.plrecipe_place.feature.place.entity.CoursePlace;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import com.sixcandoit.plrecipe_place.feature.place.entity.PlaceStar;
import com.sixcandoit.plrecipe_place.feature.place.repository.CourseMapper;
import com.sixcandoit.plrecipe_place.feature.place.repository.PlaceMapper;
import com.sixcandoit.plrecipe_place.feature.place.repository.PlaceRepository;
import com.sixcandoit.plrecipe_place.feature.place.repository.PlaceStarRepository;
import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    /* 코스id로 한 코스의 정보와 코스에 해당하는 장소 리스트 select (CoursePlace) */
    public List<CoursePlace> selectCoursePlaceByCourseId(int courseId){
        return courseMapper.selectCoursePlaceByCourseId(courseId);
    }

    /* 코스id에 해당하는 장소 리스트 select */
    public List<Place> getPlacesByCourseName(int courseId){ return courseMapper.getPlacesByCourseName(courseId);}

    /* 멤버id로 멤버가 작성한 코스 리스트 select */
    public List<Course> selectCourseByMember(int memberId){
        return courseMapper.selectCourseByMember(memberId);
    }
}
