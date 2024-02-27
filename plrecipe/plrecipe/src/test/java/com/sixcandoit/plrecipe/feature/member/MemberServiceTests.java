package com.sixcandoit.plrecipe.feature.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MemberServiceTests {
    @Autowired
    private Member memberService;
    @Test
    void viewAllMember() {
        List<MemberDTO> member = memberService.selectAllMember();
        member.forEach(System.out::println);

        assertNotNull(member);
    }
}
