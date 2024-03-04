package com.sixcandoit.plrecipe_place.feature.place.controller;

import com.sixcandoit.plrecipe_place.feature.place.dto.SearchPlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
import java.util.List;


@Controller
@RequestMapping("/place")
@Slf4j
public class PlaceController {

    private Environment env;
    private final PlaceService placeService;

    @Autowired
    public PlaceController(Environment env, PlaceService placeService) {
        this.env = env;
        this.placeService = placeService;
    }

    @GetMapping("/searchPlace/{keyword}")
    public String searchPlace(@PathVariable String keyword, Model model) {
        
        List<SearchPlaceDTO> searchPlaces = placeService.getSearchPlaceByAPI(keyword);
        model.addAttribute("searchPlaces", searchPlaces);

        System.out.println("searchPlaces = " + searchPlaces);
        
        return "place/search_result";
    }

}
