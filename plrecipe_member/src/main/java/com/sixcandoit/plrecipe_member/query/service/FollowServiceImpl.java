package com.sixcandoit.plrecipe_member.query.service;

import com.sixcandoit.plrecipe_member.query.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.query.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.query.repository.FollowMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService{

    private final ModelMapper mapper;
    private final FollowMapper followMapper;

    @Autowired
    public FollowServiceImpl(ModelMapper mapper, FollowMapper followMapper) {
        this.mapper = mapper;
        this.followMapper = followMapper;
    }

    @Override
    public List<FollowDTO> selectAllFollows() {
        return followMapper.selectAllFollow();
    }

    @Override
    public List<MemberDTO> selectFollowById(int followId) {
        return followMapper.selectFollowById(followId);
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
