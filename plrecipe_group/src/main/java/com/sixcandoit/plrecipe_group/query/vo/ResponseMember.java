package com.sixcandoit.plrecipe_group.query.vo;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
public class ResponseMember {
    private int memberId;
    private String memberName;
    private String memberNickname;
    private String memberNumber;
}