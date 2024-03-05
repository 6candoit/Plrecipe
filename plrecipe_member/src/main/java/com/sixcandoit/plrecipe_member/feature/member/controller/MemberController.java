package com.sixcandoit.plrecipe_member.feature.member.controller;

import com.sixcandoit.plrecipe_member.feature.member.service.MemberService;
import com.sixcandoit.plrecipe_member.feature.member.service.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


}