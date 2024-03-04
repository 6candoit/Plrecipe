package com.sixcandoit.plrecipe_member.aggregate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "plrecipe_member")
@Table(name = "member_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
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
    private String joinDate;

    @Column(name = "withdrawal_date")
    private String withdrawalDate;

    @Column(name = "member_grade")
    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;

    @Column(name = "member_status")
    private String memberStatus;

}
