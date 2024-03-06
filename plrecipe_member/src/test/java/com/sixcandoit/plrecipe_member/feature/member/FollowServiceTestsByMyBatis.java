package com.sixcandoit.plrecipe_member.feature.member;

import com.sixcandoit.plrecipe_member.feature.member.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.feature.member.service.FollowService;
import com.sixcandoit.plrecipe_member.feature.member.service.FollowServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FollowServiceTestsByMyBatis {

    @Autowired
    private FollowService followService;

    @ParameterizedTest
    @ValueSource(ints = {1})
    void selectMemberWhoFollowsMe(int userFollow) {

        List<FollowDTO> followList1 = followService.selectMemberWhoFollowsMe(userFollow);
        followList1.forEach(System.out::println);

        assertTrue(!followList1.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    void selectMemberWhoIFollow(int userFollower) {

        List<FollowDTO> followList2 = followService.selectMemberWhoIFollow(userFollower);
        followList2.forEach(System.out::println);

        assertTrue(!followList2.isEmpty());
    }

}