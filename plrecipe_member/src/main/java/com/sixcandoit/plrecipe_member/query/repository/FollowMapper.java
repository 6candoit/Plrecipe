package com.sixcandoit.plrecipe_member.query.repository;

import com.sixcandoit.plrecipe_member.query.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.query.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {
    List<FollowDTO> selectAllFollow();
    List<FollowDTO> selectMemberWhoFollowsMe(int userFollow);
    List<FollowDTO> selectMemberWhoIFollow(int userFollower);
    List<MemberDTO> selectFollowById(int followId);
}
