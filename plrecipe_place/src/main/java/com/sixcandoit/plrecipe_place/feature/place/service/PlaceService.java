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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PlaceService {

    private final ModelMapper mapper;
    private final PlaceRepository placeRepository;
    private final PlaceStarRepository placeStarRepository;
    private final PlaceMapper placeMapper;
    private final CourseMapper courseMapper;
    private Environment env;

    @Autowired
    public PlaceService(ModelMapper mapper, PlaceRepository placeRepository, PlaceStarRepository placeStarRepository, PlaceMapper placeMapper, CourseMapper courseMapper, Environment env) {
        this.mapper = mapper;
        this.placeRepository = placeRepository;
        this.placeStarRepository = placeStarRepository;
        this.placeMapper = placeMapper;
        this.courseMapper = courseMapper;
        this.env = env;
    }

    public List<Place> selectAllPlace() {
        return placeMapper.selectAllPlace();
    }

    public List<Place> selectPlaceByFilter(Map<String, Object> filter) { return placeMapper.selectPlaceByFilter(filter);}

    public List<SearchPlaceDTO> getSearchPlaceByAPI(String keyword){

        JSONArray searchPlaces = getSearchPlaceByKeyword(keyword);
        List<SearchPlaceDTO> searchPlaceList = new ArrayList<>();

        for (int i = 0; i < searchPlaces.size(); i++) {

            JSONObject place = (JSONObject) searchPlaces.get(i);

            SearchPlaceDTO searchPlaceDTO = new SearchPlaceDTO();
            searchPlaceDTO.setPlaceName(place.get("place_name").toString());
            searchPlaceDTO.setPlaceLocation(place.get("road_address_name").toString());
            searchPlaceDTO.setPlacePhoneNum(place.get("phone").toString());

            searchPlaceList.add(searchPlaceDTO);
        }

        return searchPlaceList;
    }

    public List<CoursePlace> selectCoursePlaceByCourseId(int courseId){
        return courseMapper.selectCoursePlaceByCourseId(courseId);
    }

    public List<PlaceStar> selectStarByPlace(int placeId) { return placeMapper.selectStarByPlace(placeId);}

    public List<Place> getPlacesByCourseName(int courseId){ return courseMapper.getPlacesByCourseName(courseId);}

    public List<Course> selectCourseByMember(String memberEmail){
        return placeMapper.selectCourseByMember(memberEmail);
    }

    public List<PlaceStar> selectStarByMember(String memberEmail){
        return placeMapper.selectStarByMember(memberEmail);
    }


    public void registPlace(PlaceDTO newPlace) {
        placeRepository.save(mapper.map(newPlace, Place.class));
    }

    public void registStar(PlaceStarDTO newStar) {
        placeStarRepository.save(mapper.map(newStar, PlaceStar.class));
    }

    @Transactional
    public void modifyStar(PlaceStarDTO modifyStar) {
        PlaceStar foundStar = placeStarRepository.findById(modifyStar.getStarId()).orElseThrow(IllegalArgumentException::new);
        foundStar.setStarPoint(modifyStar.getStarPoint());
        foundStar.setStarComment(modifyStar.getStarComment());
    }

    @Transactional
    public void deletePlace(int placeId) {
        placeRepository.deleteById(placeId);
    }


    private JSONArray getSearchPlaceByKeyword(String keyword){

        String apiKey = env.getProperty("plrecipe.rest-key");
        String baseUrl = "https://dapi.kakao.com/v2/local/search/keyword.json";
        JSONArray searchPlaces = null;

        try {
            keyword = URLEncoder.encode(keyword, "UTF-8");

            String requestUrl = baseUrl + "?query=" + keyword;

            URL url = new URL(requestUrl);

            URLConnection conn = url.openConnection();

            conn.setRequestProperty("Authorization", "KakaoAK " + apiKey);

            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuffer data = new StringBuffer();
            String jsonData = null;
            String line;

            while ((line=br.readLine()) != null){
                data.append(line);
            }
            jsonData = data.toString();
            br.close();

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonData);
            searchPlaces = (JSONArray) jsonObject.get("documents");

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return searchPlaces;
    }
}
