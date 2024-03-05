package com.sixcandoit.plrecipe_member.feature.member.service;

import com.sixcandoit.plrecipe_member.feature.member.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.feature.member.repository.FollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService{

    private final FollowMapper followMapper;

    @Autowired
    public FollowServiceImpl(FollowMapper followMapper) {
        this.followMapper = followMapper;
    }

    public List<FollowDTO> selectAllFollow() {
        return followMapper.selectAllFollow();
    }

    @Override
    public List<FollowDTO> selectMemberWhoFollowsMe(int userFollow) {
        return followMapper.selectMemberWhoFollowsMe(userFollow);
    }

    @Override
    public List<FollowDTO> selectMemberWhoIFollow(int userFollower) {
        return followMapper.selectMemberWhoIFollow(userFollower);
    }

}