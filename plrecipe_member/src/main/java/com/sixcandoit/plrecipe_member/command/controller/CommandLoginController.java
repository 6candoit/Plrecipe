package com.sixcandoit.plrecipe_member.command.controller;

import com.sixcandoit.plrecipe_member.command.dto.RegisterDTO;
import com.sixcandoit.plrecipe_member.command.vo.ResponseUser;
import com.sixcandoit.plrecipe_member.command.service.CommandMemberService;
import com.sixcandoit.plrecipe_member.command.vo.RequestUser;
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
public class CommandLoginController {

    private final CommandMemberService commandMemberService;
    private final ModelMapper modelMapper;

    @Autowired
    public CommandLoginController(CommandMemberService commandMemberService, ModelMapper modelMapper) {
        this.commandMemberService = commandMemberService;
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

//        생성된 Member 객체를 Member 테이블에 추가
//        Member newMember = Member.createMember(user);
        RegisterDTO userDTO = modelMapper.map(user, RegisterDTO.class);

        commandMemberService.registUser(userDTO);

        ResponseUser responseUser = modelMapper.map(userDTO, ResponseUser.class);

//        return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);

//        memberRepository.save(user);
    }

}
