package com.sixcandoit.plrecipe.feature.follow.repository;

import com.sixcandoit.plrecipe.feature.follow.dto.FollowDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {

    List<FollowDTO> selectAllFollow();

    List<FollowDTO> selectMemberWhoFollowsMe(String userFollow);

    List<FollowDTO> selectMemberWhoIFollow(String userFollower);
}