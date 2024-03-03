package com.sixcandoit.plrecipe.feature.follow.entity;

import com.sixcandoit.plrecipe.feature.follow.dto.FollowDTO;
import com.sixcandoit.plrecipe.feature.follow.repository.FollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Follow {
    private final FollowMapper followMapper;

    @Autowired
    public Follow(FollowMapper followMapper) { this.followMapper = followMapper;}

    public List<FollowDTO> selectAllFollow() {
        return followMapper.selectAllFollow();
    }

    public List <FollowDTO> selectMemberWhoFollowsMe(String userFollow) {
        return followMapper.selectMemberWhoFollowsMe(userFollow);}

    public List<FollowDTO> selectMemberWhoIFollow(String userFollower) {
        return followMapper.selectMemberWhoIFollow(userFollower);
    }

}