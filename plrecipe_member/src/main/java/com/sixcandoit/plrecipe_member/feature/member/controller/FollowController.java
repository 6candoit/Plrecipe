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
//@RequestMapping("/plrecipe-follow")
public class FollowController {

    private final FollowServiceImpl followServiceImpl;
    private final ModelMapper modelMapper;

    @Autowired
    public FollowController(FollowServiceImpl followServiceImpl, ModelMapper modelMapper) {
        this.followServiceImpl = followServiceImpl;
        this.modelMapper = modelMapper;
    }

    // 전체 팔로우 조회
    @GetMapping("/follows")
    public List<FollowDTO> selectAllFollows(){
        return followServiceImpl.selectAllFollows();
    }

    //  followId로 팔로우 조회
    @GetMapping("/searchFollow/{followId}")
    public ResponseEntity<ResponseFollow> selectFollowById(@PathVariable("followId") int followId) {
        FollowDTO followDTO = followServiceImpl.selectFollowById(followId);
        ResponseFollow returnValue = modelMapper.map(followDTO, ResponseFollow.class);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

    // 나를 팔로우하는 전체 회원 조회 -> 내 팔로워 조회
    @GetMapping("follower/{userFollow}")
    public List<FollowDTO> selectMemberWhoFollowsMe(@PathVariable("userFollow") int userFollow) {
        return followServiceImpl.selectMemberWhoFollowsMe(userFollow);
    }

    // 내가 팔로우 하는 회원 전체 조회 -> 내 팔로잉 조회
    @GetMapping("following/{userFollower}")
    public List<FollowDTO> selectMemberWhoIFollow(@PathVariable("userFollower") int userFollower) {
        return followServiceImpl.selectMemberWhoIFollow(userFollower);
    }

    // 팔로우 하기
    @PostMapping("/new")
    private ResponseEntity<ResponseFollow> followMember(@RequestBody RequestFollow follow) {

        FollowDTO followDTO = modelMapper.map(follow, FollowDTO.class);
        followServiceImpl.followMember(followDTO);
        ResponseFollow responseFollow = modelMapper.map((followDTO), ResponseFollow.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseFollow);
    }

    // 팔로우 취소하기
    @GetMapping("/unfollow")
    public void cancelFollow() {    }

    // 팔로우 취소하기
    @DeleteMapping("/unfollow/{followId}")
    public ResponseEntity<ResponseFollow> cancelFollow(@PathVariable int followId) {
        followServiceImpl.cancelFollow(followId);
        return ResponseEntity.ok().build();
    }

}
