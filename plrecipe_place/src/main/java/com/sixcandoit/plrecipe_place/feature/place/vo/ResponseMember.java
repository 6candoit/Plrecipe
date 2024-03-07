package com.sixcandoit.plrecipe_place.feature.place.vo;
import lombok.Data;

@Data
public class ResponseMember {
    private int memberId;
    private String memberName;
    private String memberNickname;
    private MemberGradeVO memberGrade;
}
