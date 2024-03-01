package com.sixcandoit.plrecipe_member.feature.follow.service;

import com.sixcandoit.plrecipe_member.feature.follow.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.feature.follow.repository.FollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    private FollowMapper followMapper;

    @Autowired
    public FollowService(FollowMapper followMapper) {
        this.followMapper = followMapper;
    }

    public List<FollowDTO> selectAllFollow() {
        return followMapper.selectAllFollow();
    }

    public List<FollowDTO> selectMemberWhoFollowsMe(String userFollow) {
        return followMapper.selectMemberWhoFollowsMe(userFollow);
    }

    public List<FollowDTO> selectMemberWhoIFollow(String userFollower) {
        return followMapper.selectMemberWhoIFollow(userFollower);
    }


}
