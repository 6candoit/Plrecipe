package com.sixcandoit.plrecipe_member.command.service;

import com.sixcandoit.plrecipe_member.command.dto.FollowDTO;

import java.util.List;

public interface CommandFollowService {
    void followMember(FollowDTO followDTO);
    void cancelFollow(int followId);
}
