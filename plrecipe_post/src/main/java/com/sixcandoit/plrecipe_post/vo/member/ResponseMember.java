package com.sixcandoit.plrecipe_post.vo.member;

import lombok.Data;

@Data
public class ResponseMember {
    private int memberId;
    private String memberName;
    private String memberNickname;
    private MemberGradeVO memberGrade;
}
