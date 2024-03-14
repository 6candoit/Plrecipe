package com.sixcandoit.plrecipe_place.query.service;

import com.sixcandoit.plrecipe_place.query.aggregate.Course;
import com.sixcandoit.plrecipe_place.query.aggregate.CourseAndPlace;
import com.sixcandoit.plrecipe_place.query.client.MemberServiceClient;
import com.sixcandoit.plrecipe_place.query.dto.CourseAndPlaceDTO;
import com.sixcandoit.plrecipe_place.query.dto.CourseDTO;
import com.sixcandoit.plrecipe_place.query.dto.PlaceStarDTO;
import com.sixcandoit.plrecipe_place.query.dto.SearchPlaceDTO;
import com.sixcandoit.plrecipe_place.query.aggregate.Place;
import com.sixcandoit.plrecipe_place.query.aggregate.PlaceStar;
import com.sixcandoit.plrecipe_place.query.repository.PlaceMapper;
import com.sixcandoit.plrecipe_place.query.vo.ResponseMember;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final ModelMapper mapper;
    private final PlaceMapper placeMapper;
    private final MemberServiceClient memberServiceClient;
    private final Environment env;

    public PlaceServiceImpl(ModelMapper mapper, PlaceMapper placeMapper, MemberServiceClient memberServiceClient, Environment env) {
        this.mapper = mapper;
        this.placeMapper = placeMapper;
        this.memberServiceClient = memberServiceClient;
        this.env = env;
    }

    public List<SearchPlaceDTO> getSearchPlaceByAPI(String keyword){

        /* restApi 이용해서 사용자가 검색한 장소 리스트 JSONArray로 가져오기 */
        JSONArray searchPlaces = getSearchPlaceByKeyword(keyword);
        List<SearchPlaceDTO> searchPlaceList = new ArrayList<>();

        /* 장소 리스트 SearchPlace 객체로 담아서 변환 */
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

    /* 모든 장소 select */
    public List<Place> selectAllPlace() {
        return placeMapper.selectAllPlace();
    }

    /* 장소 select */
    public List<Place> selectPlaceById(int placeId) {

        List<Place> place = new ArrayList<>();
        place.add(placeMapper.selectPlaceById(placeId));

        return place;
    }

    public List<Place> selectPlaceByFilter(Map<String, Object> filter) { return placeMapper.selectPlaceByFilter(filter);}

    /* 장소에 달린 별점 select */
    public List<PlaceStarDTO> selectStarByPlace(int placeId) {

        List<PlaceStar> placeStarList = placeMapper.selectStarByPlace(placeId);
        return changePlaceStarToPlaceStarDTO(placeStarList);
    }

    /* 멤버id로 멤버가 작성한 별점 리스트 select  */
    public List<PlaceStarDTO> selectStarByMember(int memberId){

        List<PlaceStar> placeStarList = placeMapper.selectStarByMember(memberId);
        return changePlaceStarToPlaceStarDTO(placeStarList);
    }

    public List<PlaceStarDTO> changePlaceStarToPlaceStarDTO(List<PlaceStar> placeStarList){

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<PlaceStarDTO> placeStarDTOList = placeStarList.stream()
                .map(placeStar -> mapper.map(placeStar, PlaceStarDTO.class))
                .collect(Collectors.toList());

        for (int i = 0; i < placeStarDTOList.size(); i++) {
            ResponseMember member = memberServiceClient.getMemberInfo(placeStarList.get(i).getMemberId());
            placeStarDTOList.get(i).setMember(member);
        }

        return placeStarDTOList;
    }

    /* 멤버id로 멤버가 작성한 코스 리스트 select */
    public List<CourseDTO> selectCourseByMember(int memberId){

        List<Course> courseList = placeMapper.selectCourseByMember(memberId);

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CourseDTO> courseDTOList = courseList.stream()
                .map(course -> mapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());

        for (int i = 0; i < courseDTOList.size(); i++) {
            ResponseMember rm = memberServiceClient.getMemberInfo(courseList.get(i).getMemberId());
            courseDTOList.get(i).setMember(rm);
        }

        return courseDTOList;
    }

    /* 코스id로 한 코스의 정보와 코스에 해당하는 장소 리스트 select (CoursePlace) */
    public CourseAndPlaceDTO selectCoursePlaceByCourseId(int courseId){
        CourseAndPlace cp = placeMapper.selectCoursePlaceByCourseId(courseId);
        ResponseMember member = memberServiceClient.getMemberInfo(cp.getMemberId());
        CourseAndPlaceDTO courseAndPlace = new CourseAndPlaceDTO(cp.getCourseId(), cp.getCourseName(), member, cp.getPlaces());
        return courseAndPlace;
    }

    /* 코스id에 해당하는 장소 리스트 select */
    public List<Place> getPlacesByCourseName(int courseId){
        return placeMapper.getPlacesByCourseName(courseId);
    }

    /* 카카오 장소 rest-api로 사용자가 검색한 키워드 장소 검색해서 반환 */
    private JSONArray getSearchPlaceByKeyword(String keyword){

        /* yml파일에서 api 인증 키 불러오기 */
        String apiKey = env.getProperty("plrecipe.rest-key");
        String baseUrl = "https://dapi.kakao.com/v2/local/search/keyword.json";
        JSONArray searchPlaces = null;

        try {
            keyword = URLEncoder.encode(keyword, "UTF-8");

            /* 요청 url 작성 */
            String requestUrl = baseUrl + "?query=" + keyword;

            URL url = new URL(requestUrl);

            URLConnection conn = url.openConnection();

            /* 인증키 세팅 */
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
            JSONObject jsonObject = (JSONObject) parser.parse(jsonData);  // 받아온 String -> JsonObject로 파싱

            /* 장소 정보들 들어있는 documents 뽑아서 JSONArray로 변환 */
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
