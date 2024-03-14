//package com.sixcandoit.plrecipe_member.feature.member;
//
//import com.sixcandoit.plrecipe_member.command.dto.MemberDTO;
//import com.sixcandoit.plrecipe_member.command.service.CommandMemberService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringBootTest
//public class CommandMemberServiceTestsByMyBatis {
//
//    @Autowired
//    private CommandMemberService commandMemberService;
//
//    @Test
//    void viewAllMember() {
//
//        List<MemberDTO> member = commandMemberService.selectAllMember();
//        member.forEach(System.out::println);
//
//        assertNotNull(member);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"1"})
//    void selectMemberByLikePost(int memberId) {
//
//        List<MemberDTO> memberList3 = commandMemberService.selectMemberByLikePost(memberId);
//        memberList3.forEach(System.out::println);
//
//        assertTrue(!memberList3.isEmpty());
//    }
//}
