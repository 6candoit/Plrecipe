package com.sixcandoit.plrecipe_member.feature.member.controller;

import com.sixcandoit.plrecipe_member.feature.member.dto.RegisterDTO;
import com.sixcandoit.plrecipe_member.feature.vo.ResponseUser;
import com.sixcandoit.plrecipe_member.feature.member.service.MemberService;
import com.sixcandoit.plrecipe_member.feature.vo.RequestUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/login")
public class LoginController {

    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @Autowired
    public LoginController(MemberService memberService, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("loginSuccess")
    public String loginSuccess() {
        return "loginSuccesss";
    }

    @PostMapping("/login-process")
    public String loginProcess() {
        return "loginSuccess";
    }

    @PostMapping("loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }

    @GetMapping("/register")
    public ModelAndView showRegistrationForm(Model model) {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseUser> register (@RequestBody RequestUser user) {


//        memberService.registUser(RegisterDTO registerDTO);

        // 생성된 Member 객체를 Member 테이블에 추가
//        Member newMember = Member.createMember(user);
        RegisterDTO userDTO = modelMapper.map(user, RegisterDTO.class);



        memberService.registUser(userDTO);

        ResponseUser responseUser = modelMapper.map(userDTO, ResponseUser.class);

//        return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);

//        memberRepository.save(user);
    }

//    @PostMapping("/register2")
//    public ResponseEntity<?> register () {
//
//        System.out.println("오나");
//
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//
////        memberRepository.save(user);
//    }
}
