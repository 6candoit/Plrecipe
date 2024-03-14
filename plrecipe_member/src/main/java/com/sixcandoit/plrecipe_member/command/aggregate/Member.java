package com.sixcandoit.plrecipe_member.command.aggregate;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "plrecipe_member")
@Table(name = "member_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "password")
    private String password;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_nickname")
    private String memberNickname;

    @Column(name = "member_number")
    private String memberNumber;

    @Column(name = "join_date")
    private String joinDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());;

    @Column(name = "withdrawal_date")
    private String withdrawalDate = null;

    @Column(name = "member_grade")
    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade = MemberGrade.ROLL_MEMBER;

    @Column(name = "member_status")
    private String memberStatus = "Y";

    public static Member createMember(Member user, PasswordEncoder passwordEncoder) {

        Member member = new Member();
        member.setMemberName(user.getMemberName());
        member.setMemberEmail(user.getMemberEmail());
        member.setMemberNumber(user.getMemberNumber());
        member.setMemberNickname(user.getMemberNickname());
//        member.setJoinDate(user.getJoinDate());
//        member.setMemberStatus(user.getMemberStatus());
//        member.setMemberGrade(user.getMemberGrade());
//        member.setWithdrawalDate(user.getWithdrawalDate());

        String password = passwordEncoder.encode(user.getPassword());
        member.setPassword(password);

        member.setMemberGrade(MemberGrade.ROLL_MEMBER);

        return member;
    }
}
