package com.sixcandoit.plrecipe_member.command.controller;

import com.sixcandoit.plrecipe_member.command.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.command.aggregate.Member;
import com.sixcandoit.plrecipe_member.command.service.CommandMemberService;
import com.sixcandoit.plrecipe_member.command.vo.RequestMember;
import com.sixcandoit.plrecipe_member.command.vo.ResponseMember;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
//@RequestMapping("/plrecipe-member")
public class CommandMemberController {

    private final CommandMemberService commandMemberService;
    private final ModelMapper modelMapper;

    @Autowired
    public CommandMemberController(CommandMemberService commandMemberService, ModelMapper modelMapper) {
        this.commandMemberService = commandMemberService;
        this.modelMapper = modelMapper;
    }

    // 회원정보 수정
    @PatchMapping("/modify/{memberId}")
    public ResponseEntity<Member> modifyMember(@RequestBody RequestMember requestMember, @PathVariable int memberId) {
        return ResponseEntity.ok(commandMemberService.modifyMember(memberId, requestMember));
    }

    // 회원탈퇴 -> 탈퇴날짜 입력 및 memberStatus 변경
    @PatchMapping("/withdraw/{memberId}")
    public ResponseEntity<Member> withdrawMember(@RequestBody RequestMember requestMember, @PathVariable int memberId) {
        return ResponseEntity.ok(commandMemberService.withdrawMember(memberId, requestMember));
    }
}