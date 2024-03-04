package com.sixcandoit.plrecipe_member.feature.follow;

import com.sixcandoit.plrecipe_member.feature.member.dto.FollowDTO;
import com.sixcandoit.plrecipe_member.feature.member.service.FollowService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FollowServiceTestsByMyBatis {

    @Autowired
    private FollowService followService;

//    @Test
//    void selectAllFollow() {
//
//        List<FollowDTO> follows = followService.selectAllFollow();
//        follows.forEach(System.out::println);
//
//        assertNotNull(follows);
//    }

    @ParameterizedTest
    @ValueSource(strings = {"mfk5gd@daum.net"})
    void selectMemberWhoFollowsMe(String userFollow) {

        List<FollowDTO> followList1 = followService.selectMemberWhoFollowsMe(userFollow);
        followList1.forEach(System.out::println);

        assertTrue(!followList1.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"lehyw@nate.com"})
    void selectMemberWhoIFollow(String userFollower) {

        List<FollowDTO> followList2 = followService.selectMemberWhoIFollow(userFollower);
        followList2.forEach(System.out::println);

        assertTrue(!followList2.isEmpty());
    }

}