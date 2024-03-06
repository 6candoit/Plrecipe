package com.sixcandoit.plrecipe_member.feature.member.repository;

import com.sixcandoit.plrecipe_member.feature.member.dto.FollowDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {
    List<FollowDTO> selectAllFollow();
    List<FollowDTO> selectMemberWhoFollowsMe(int userFollow);
    List<FollowDTO> selectMemberWhoIFollow(int userFollower);
}
