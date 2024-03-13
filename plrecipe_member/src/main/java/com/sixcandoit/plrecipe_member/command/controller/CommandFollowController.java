package com.sixcandoit.plrecipe_member.command.controller;

import com.sixcandoit.plrecipe_member.command.vo.RequestFollow;
import com.sixcandoit.plrecipe_member.command.vo.ResponseFollow;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sixcandoit.plrecipe_member.command.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.command.service.CommandFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/plrecipe-follow")
public class CommandFollowController {

    private final CommandFollowService commandFollowService;
    private final ModelMapper modelMapper;

    @Autowired
    public CommandFollowController(CommandFollowService commandFollowService, ModelMapper modelMapper) {
        this.commandFollowService = commandFollowService;
        this.modelMapper = modelMapper;
    }

//
//    //  followId로 팔로우 조회
//    @GetMapping("/searchFollow/{followId}")
//    public ResponseEntity<ResponseFollow> selectFollowById(@PathVariable("followId") int followId) {
//        FollowDTO followDTO = commandFollowService.selectFollowById(followId);
//        ResponseFollow returnValue = modelMapper.map(followDTO, ResponseFollow.class);
//
//        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
//    }

//    // 나를 팔로우하는 전체 회원 조회 -> 내 팔로워 조회
//    @GetMapping("follower/{userFollow}")
//    public List<FollowDTO> selectMemberWhoFollowsMe(@PathVariable("userFollow") int userFollow) {
//        return commandFollowService.selectMemberWhoFollowsMe(userFollow);
//    }
//
//    // 내가 팔로우 하는 회원 전체 조회 -> 내 팔로잉 조회
//    @GetMapping("following/{userFollower}")
//    public List<FollowDTO> selectMemberWhoIFollow(@PathVariable("userFollower") int userFollower) {
//        return commandFollowService.selectMemberWhoIFollow(userFollower);
//    }

    // 팔로우 하기
    @PostMapping("/new")
    private ResponseEntity<ResponseFollow> followMember(@RequestBody RequestFollow follow) {

        FollowDTO followDTO = modelMapper.map(follow, FollowDTO.class);
        commandFollowService.followMember(followDTO);
        ResponseFollow responseFollow = modelMapper.map((followDTO), ResponseFollow.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseFollow);
    }

    // 팔로우 취소하기
    @GetMapping("/unfollow")
    public void cancelFollow() {    }

    // 팔로우 취소하기
    @DeleteMapping("/unfollow/{followId}")
    public ResponseEntity<ResponseFollow> cancelFollow(@PathVariable int followId) {
        commandFollowService.cancelFollow(followId);
        return ResponseEntity.ok().build();
    }

}
