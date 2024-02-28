package com.sixcandoit.plrecipe.feature.follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Follow {
    private final FollowMapper followMapper;

    @Autowired
    public Follow(FollowMapper followMapper) {
        this.followMapper = followMapper;}

    public List<FollowDTO> selectAllFollow() {
        return followMapper.selectAllFollow();
    }
}
