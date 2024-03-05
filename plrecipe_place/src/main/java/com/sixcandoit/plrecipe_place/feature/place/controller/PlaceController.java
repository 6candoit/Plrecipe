package com.sixcandoit.plrecipe_place.feature.place.controller;

import com.sixcandoit.plrecipe_place.feature.place.dto.SearchPlaceDTO;
import com.sixcandoit.plrecipe_place.feature.place.service.PlaceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/place")
@Slf4j
public class PlaceController {
    private final PlaceServiceImpl placeServiceImpl;

    @Autowired
    public PlaceController(PlaceServiceImpl placeServiceImpl) {
        this.placeServiceImpl = placeServiceImpl;
    }

    /* 장소 추가를 위해 키워드로 장소 검색해서 장소 리스트 받아오기 */
    @GetMapping("/searchPlace/{keyword}")
    public String searchPlace(@PathVariable String keyword, Model model) {
        
        List<SearchPlaceDTO> searchPlaces = placeServiceImpl.getSearchPlaceByAPI(keyword);
        model.addAttribute("searchPlaces", searchPlaces);

        System.out.println("searchPlaces = " + searchPlaces);
        
        return "place/search_result";
    }

}
