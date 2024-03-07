package com.sixcandoit.plrecipe_member.feature.member.controller;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.feature.member.entity.Member;
import com.sixcandoit.plrecipe_member.feature.member.service.MemberServiceImpl;
import com.sixcandoit.plrecipe_member.feature.vo.RequestMember;
import com.sixcandoit.plrecipe_member.feature.vo.ResponseMember;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import com.sixcandoit.plrecipe_member.feature.member.repository.MemberRepository;
import com.sixcandoit.plrecipe_member.feature.member.service.MemberService;

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

    // 회원전체조회
    @GetMapping("/members")
    public List<MemberDTO> selectAllMember() {
        return memberService.selectAllMember();
    }

    // 회원ID로 회원 조회
    @GetMapping("/searchMember/{memberId}")
    public ResponseEntity<ResponseMember> selectMemberById(@PathVariable("memberId")int memberId) {

        MemberDTO memberDTO = memberService.selectMemberById(memberId);
        ResponseMember returnValue = modelMapper.map(memberDTO, ResponseMember.class);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

    // 회원가입
    @PostMapping("/regist")
    private ResponseEntity<ResponseMember> registMember(@RequestBody RequestMember member) {

        MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);
        memberService.registMember(memberDTO);
        ResponseMember responseMember = modelMapper.map(memberDTO, ResponseMember.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMember);
    }

    // 회원정보 수정
    @PatchMapping("/modify/{memberId}")
    public ResponseEntity<Member> modifyMember(@RequestBody RequestMember requestMember, @PathVariable int memberId) {
        return ResponseEntity.ok(memberService.modifyMember(memberId, requestMember));
    }

    // 회원탈퇴 -> 탈퇴날짜 입력 및 memberStatus 변경
    @PatchMapping("/withdraw/{memberId}")
    public ResponseEntity<Member> withdrawMember(@RequestBody RequestMember requestMember, @PathVariable int memberId) {
        return ResponseEntity.ok(memberService.withdrawMember(memberId, requestMember));
    }
}