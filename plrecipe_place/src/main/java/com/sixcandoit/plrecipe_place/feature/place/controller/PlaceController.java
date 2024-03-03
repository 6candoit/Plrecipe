package com.sixcandoit.plrecipe_place.feature.place.controller;

import com.sixcandoit.plrecipe_place.feature.place.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


@Controller
@RequestMapping("/place")
@Slf4j
public class PlaceController {
    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/searchPlace/{keyword}")
    public String searchPlace(@PathVariable String keyword, Model model) {
        log.info("keyword : " + keyword);

        String apiKey = "카카오 api 앱 키";
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

            System.out.println("jsonData = " + jsonData);

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonData);
            searchPlaces = (JSONArray) jsonObject.get("documents");
            System.out.println("searchPlaces = " + searchPlaces);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("searchPlaces", searchPlaces);
        return "search_result";
    }

}
