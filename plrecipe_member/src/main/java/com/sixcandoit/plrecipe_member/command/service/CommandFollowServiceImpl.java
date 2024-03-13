package com.sixcandoit.plrecipe_member.command.service;

import com.sixcandoit.plrecipe_member.command.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.command.aggregate.Follow;
import com.sixcandoit.plrecipe_member.command.repositoty.FollowRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandFollowServiceImpl implements CommandFollowService {

    private final ModelMapper mapper;
    private final FollowRepository followRepository;

    @Autowired
    public CommandFollowServiceImpl(ModelMapper mapper, FollowRepository followRepository) {
        this.mapper = mapper;
        this.followRepository = followRepository;
    }
    @Override
    public void cancelFollow(int followId) {
        followRepository.deleteById(followId);
    }


    @Override
    public void followMember(FollowDTO followDTO) {
        Follow follow = mapper.map(followDTO, Follow.class);
        followRepository.save((follow));
    }


}