package com.sixcandoit.plrecipe_member.query.controller;

import com.sixcandoit.plrecipe_member.query.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.query.service.FollowService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/plrecipe-follow")
public class FollowController {

    private final FollowService followService;
    private final ModelMapper modelMapper;

    @Autowired
    public FollowController(FollowService followService, ModelMapper modelMapper) {
        this.followService = followService;
        this.modelMapper = modelMapper;
    }

    // 전체 팔로우 조회
    @GetMapping("/follows")
    public List<FollowDTO> selectAllFollows(){
        return followService.selectAllFollows();
    }

//    //  followId로 팔로우 조회
//    @GetMapping("/searchFollow/{followId}")
//    public ResponseEntity<ResponseFollow> selectFollowById(@PathVariable("followId") int followId) {
//        FollowDTO followDTO = commandFollowService.selectFollowById(followId);
//        ResponseFollow returnValue = modelMapper.map(followDTO, ResponseFollow.class);
//
//        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
//    }

    // 나를 팔로우하는 전체 회원 조회 -> 내 팔로워 조회
    @GetMapping("follower/{userFollow}")
    public List<FollowDTO> selectMemberWhoFollowsMe(@PathVariable("userFollow") int userFollow) {
        return followService.selectMemberWhoFollowsMe(userFollow);
    }

    // 내가 팔로우 하는 회원 전체 조회 -> 내 팔로잉 조회
    @GetMapping("following/{userFollower}")
    public List<FollowDTO> selectMemberWhoIFollow(@PathVariable("userFollower") int userFollower) {
        return followService.selectMemberWhoIFollow(userFollower);
    }

}
