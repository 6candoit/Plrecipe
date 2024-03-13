package com.sixcandoit.plrecipe_member.query.controller;


import com.sixcandoit.plrecipe_member.query.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.query.service.MemberService;
import com.sixcandoit.plrecipe_member.query.service.MemberServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/plrecipe-member")
public class MemberController {

    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberController(MemberService memberService, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    // 회원 전체조회
    @GetMapping("/members")
    public List<MemberDTO> selectAllMember() {
        return memberService.selectAllMember();
    }

    // 회원 ID별 조회
    @GetMapping("/searchMember/{memberId}")
    List<MemberDTO> selectMemberById(@PathVariable int memberId) {
        return memberService.selectMemberById(memberId);
    }

    // 회원별 좋아요 누른 게시글 조회
    @GetMapping("/searchLike/{memberId}")
    List<MemberDTO> selectLikeByMemberId(@PathVariable int memberId) {
        return memberService.selectLikeByMemberId(memberId);
    }

}