package com.sixcandoit.plrecipe_member.feature.vo;

import com.sixcandoit.plrecipe_member.feature.member.entity.MemberGrade;
import lombok.Data;

@Data
public class ResponseMember {

    private int memberId;
    private String memberEmail;
    private String password;
    private String memberName;
    private String memberNickname;
    private String memberNumber;
    private String joinDate;
    private String withdrawalDate;
    private MemberGrade memberGrade;
    private String memberStatus;
}
