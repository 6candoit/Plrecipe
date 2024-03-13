package com.sixcandoit.plrecipe_group.command.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseGroup {
    private int groupId;
    private String groupName;
    private String isGroupPublic;
    private String groupCreateDate;
    private String groupWithdrawalDate;
    private String groupComment;
    private String groupStatus;
}
