package com.sixcandoit.plrecipe_group.feature.group.vo;

import com.sixcandoit.plrecipe_group.feature.group.dto.MemberGrade;
import lombok.Data;

@Data
public class ResponseMember {
    private int memberId;
    private String memberName;
    private String memberNickname;
    private String memberNumber;
}
