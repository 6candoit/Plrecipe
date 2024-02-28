package com.sixcandoit.plrecipe.feature.follow;

import com.sixcandoit.plrecipe.feature.member.MemberDTO;
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