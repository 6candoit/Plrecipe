package com.sixcandoit.plrecipe_group.command.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMember {
    private int memberId;
    private String memberName;
    private String memberNickname;
    private String memberNumber;
}
