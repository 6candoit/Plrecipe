package com.sixcandoit.plrecipe_member.repository.mapper;

import com.sixcandoit.plrecipe_member.dto.FollowDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {

    List<FollowDTO> selectAllFollow();

    List<FollowDTO> selectMemberWhoFollowsMe(String userFollow);

    List<FollowDTO> selectMemberWhoIFollow(String userFollower);
}
