package com.sixcandoit.plrecipe_member.feature.member.controller;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.feature.member.entity.Member;
import com.sixcandoit.plrecipe_member.feature.member.repository.MemberRepository;
import com.sixcandoit.plrecipe_member.feature.member.service.MemberService;
import com.sixcandoit.plrecipe_member.feature.member.service.MemberServiceImpl;
import com.sixcandoit.plrecipe_member.feature.vo.RequestMember;
import com.sixcandoit.plrecipe_member.feature.vo.ResponseMember;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberServiceImpl memberServiceImpl;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberController(MemberServiceImpl memberServiceImpl, ModelMapper modelMapper) {
        this.memberServiceImpl = memberServiceImpl;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/members")
    public List<MemberDTO> selectAllMember(){
        return memberServiceImpl.selectAllMember();
    }

    @GetMapping("/{memberId}")
    public String findMemberById(@PathVariable int memberId, Model model) {

        MemberDTO member = memberServiceImpl.findMemberById(memberId);
        model.addAttribute("member", member);

        System.out.println("member = " + member);

        return memberServiceImpl.selectMemberById(memberId);
    }

    @PostMapping("/regist")
    private ResponseEntity<ResponseMember> registMember(@RequestBody RequestMember member){
        MemberDTO memberDTO = modelMapper.map(member,MemberDTO.class);

        memberServiceImpl.registMember(memberDTO);

        ResponseMember responseMember = modelMapper.map(memberDTO,ResponseMember.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMember);
    }

    @GetMapping("modify")
    public void modifyMember() {
    }

    @PostMapping("/modify")
    public String modifyMember(MemberDTO modifyMember) {
        memberServiceImpl.modifyMember(modifyMember);

        return "redirect:/member/" + modifyMember.getMemberId();
    }


}