package com.sixcandoit.plrecipe_member.feature.member.controller;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.feature.member.entity.Follow;
import com.sixcandoit.plrecipe_member.feature.member.service.FollowServiceImpl;
import com.sixcandoit.plrecipe_member.feature.vo.RequestFollow;
import com.sixcandoit.plrecipe_member.feature.vo.ResponseFollow;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.sixcandoit.plrecipe_member.feature.member.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.feature.member.service.FollowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {

    private final FollowServiceImpl followServiceImpl;
    private final ModelMapper modelMapper;

    @Autowired
    public FollowController(FollowServiceImpl followServiceImpl, ModelMapper modelMapper) {
        this.followServiceImpl = followServiceImpl;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/follows")
    public List<FollowDTO> selectAllFollows(){
        return followServiceImpl.selectAllFollows();
    }

    @GetMapping("/{followId}")
    public String findFollowById(@PathVariable int followId, Model model) {

        FollowDTO follow = followServiceImpl.findFollowById(followId);
        model.addAttribute("follow", follow);

        return "follow/detail";
    }

    @PostMapping("/new")
    private ResponseEntity<ResponseFollow> followMember(@RequestBody RequestFollow follow) {

        FollowDTO followDTO = modelMapper.map(follow, FollowDTO.class);
        followServiceImpl.followMember(followDTO);
        ResponseFollow responseFollow = modelMapper.map((followDTO), ResponseFollow.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseFollow);
    }

    @GetMapping("/unfollow")
    public void cancelFollow() {    }

    @DeleteMapping("/unfollow/{followId}")
    public ResponseEntity<ResponseFollow> cancelFollow(@PathVariable int followId) {
        followServiceImpl.cancelFollow(followId);
        return ResponseEntity.ok().build();
    }

}
