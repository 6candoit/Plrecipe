package com.sixcandoit.plrecipe_member.query.aggregate;

import lombok.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {

    private int memberId;

    private String memberEmail;

    private String password;

    private String memberName;

    private String memberNickname;

    private String memberNumber;

    private String joinDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());;

    private String withdrawalDate = null;

    private MemberGrade memberGrade;

    private String memberStatus = "Y";

//    public static Member createMember(Member user, PasswordEncoder passwordEncoder) {
//
//        Member member = new Member();
//        member.setMemberName(user.getMemberName());
//        member.setMemberEmail(user.getMemberEmail());
//        member.setMemberNumber(user.getMemberNumber());
//        member.setMemberNickname(user.getMemberNickname());
////        member.setJoinDate(user.getJoinDate());
////        member.setMemberStatus(user.getMemberStatus());
////        member.setMemberGrade(user.getMemberGrade());
////        member.setWithdrawalDate(user.getWithdrawalDate());
//
//        String password = passwordEncoder.encode(user.getPassword());
//        member.setPassword(password);
//
//        member.setMemberGrade(MemberGrade.ROLL_MEMBER);
//
//        return member;
//    }


}
