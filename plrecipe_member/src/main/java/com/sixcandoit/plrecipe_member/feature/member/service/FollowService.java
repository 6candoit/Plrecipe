package com.sixcandoit.plrecipe_member.feature.member.service;

import com.sixcandoit.plrecipe_member.feature.member.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;

import java.util.List;

public interface FollowService {

    void cancelFollow(int followId);
    List<FollowDTO> selectMemberWhoFollowsMe(int userFollow);
    List<FollowDTO> selectMemberWhoIFollow(int userFollower);
    FollowDTO findFollowById(int followId);
    List<FollowDTO> selectAllFollows();
    void followMember(FollowDTO followDTO);
}
