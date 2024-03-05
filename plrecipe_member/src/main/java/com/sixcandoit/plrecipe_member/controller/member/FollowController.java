package com.sixcandoit.plrecipe_member.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FollowController {
    @GetMapping(value = {"/", "main"})
    public String main() {
        return "main/main";
    }

}
