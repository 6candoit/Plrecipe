package com.sixcandoit.plrecipe_member.query.service;

import com.sixcandoit.plrecipe_member.query.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.query.dto.MemberDTO;

import java.util.List;

public interface FollowService {
    List<FollowDTO> selectMemberWhoFollowsMe(int userFollow);
    List<FollowDTO> selectMemberWhoIFollow(int userFollower);
    List<FollowDTO> selectAllFollows();
    List<MemberDTO> selectFollowById(int followId);
}
