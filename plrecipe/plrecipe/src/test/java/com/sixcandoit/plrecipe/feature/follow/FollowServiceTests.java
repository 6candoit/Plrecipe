package com.sixcandoit.plrecipe.feature.follow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FollowServiceTests {

    @Autowired
    private Follow followService;

    @ParameterizedTest
    @ValueSource(strings = {"kim123@kakao.com"})
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
