package com.sixcandoit.plrecipe_place.feature.place.controller;

import com.sixcandoit.plrecipe_place.feature.place.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

        return null;
    }

}
