package com.sixcandoit.plrecipe_member.feature;

import com.sixcandoit.plrecipe_member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MemberServiceTestsByMyBatis {

    @Autowired
    private MemberService memberService;

    @Test
    void viewAllMember() {

        List<MemberDTO> member = memberService.selectAllMember();
        member.forEach(System.out::println);

        assertNotNull(member);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void selectMemberByLikePost(int memberId) {

        List<MemberDTO> memberList3 = memberService.selectMemberByLikePost(memberId);
        memberList3.forEach(System.out::println);

        assertTrue(!memberList3.isEmpty());
    }

}
