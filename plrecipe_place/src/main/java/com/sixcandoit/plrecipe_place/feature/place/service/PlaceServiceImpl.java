package com.sixcandoit.plrecipe_place.feature.place.service;

import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.PlaceStarDTO;
import com.sixcandoit.plrecipe_place.feature.place.dto.SearchPlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.entity.Place;
import com.sixcandoit.plrecipe_place.feature.place.entity.PlaceStar;
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
public class PlaceServiceImpl implements PlaceService {

    private final ModelMapper mapper;
    private final PlaceRepository placeRepository;
    private final PlaceStarRepository placeStarRepository;
    private final PlaceMapper placeMapper;
    private Environment env;

    @Autowired
    public PlaceServiceImpl(ModelMapper mapper, PlaceRepository placeRepository, PlaceStarRepository placeStarRepository, PlaceMapper placeMapper, Environment env) {
        this.mapper = mapper;
        this.placeRepository = placeRepository;
        this.placeStarRepository = placeStarRepository;
        this.placeMapper = placeMapper;
        this.env = env;
    }

    /* 모든 장소 select */
    public List<Place> selectAllPlace() {
        return placeMapper.selectAllPlace();
    }

    /* 장소 select */
    public List<Place> selectPlaceById(int placeId) {

        List<Place> place = new ArrayList<>();
        place.add(placeRepository.findById(placeId).orElseThrow(IllegalArgumentException::new));

        return place;
    }

    public List<Place> selectPlaceByFilter(Map<String, Object> filter) { return placeMapper.selectPlaceByFilter(filter);}

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

    /* 장소에 달린 별점 select */
    public List<PlaceStar> selectStarByPlace(int placeId) { return placeMapper.selectStarByPlace(placeId);}

    /* 멤버id로 멤버가 작성한 별점 리스트 select  */
    public List<PlaceStar> selectStarByMember(int memberId){
        return placeMapper.selectStarByMember(memberId);
    }

    /* 장소 insert */
    public void registPlace(PlaceDTO newPlace) {
        placeRepository.save(mapper.map(newPlace, Place.class));
    }

    /* 별점 insert */
    public void registStar(PlaceStarDTO newStar) {
        placeStarRepository.save(mapper.map(newStar, PlaceStar.class));
    }

    /* 별점 modify */
    @Transactional
    public void modifyStar(PlaceStarDTO modifyStar) {
        PlaceStar foundStar = placeStarRepository.findById(modifyStar.getStarId()).orElseThrow(IllegalArgumentException::new);
        foundStar.setStarPoint(modifyStar.getStarPoint());
        foundStar.setStarComment(modifyStar.getStarComment());
    }

    /* 장소 delete */
    @Transactional
    public void deletePlace(int placeId) {
        placeRepository.deleteById(placeId);
    }

    /* 별점 delete */
    @Override
    public void deleteStar(int starId) {
        placeStarRepository.deleteById(starId);
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
