package com.sixcandoit.plrecipe_member.service;

import com.sixcandoit.plrecipe_member.aggregate.Follow;
import com.sixcandoit.plrecipe_member.aggregate.Member;
import com.sixcandoit.plrecipe_member.aggregate.MemberFollows;
import com.sixcandoit.plrecipe_member.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.repository.mapper.FollowMapper;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    private FollowMapper followMapper;

    @Autowired
    private EntityManager entityManager;

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

    @Transactional
    public void followMember(Member follower, Member followee) {
        MemberFollows memberFollows = new MemberFollows();
        memberFollows.setFollower(follower);
        memberFollows.setFollowee(followee);

        entityManager.persist(memberFollows);
    }

}
