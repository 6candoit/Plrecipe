package com.sixcandoit.plrecipe_group.feature.group.vo;


import lombok.Data;

@Data
public class ResponseGroup {
    private int groupId;
    private String groupName;
    private String isGroupPublic;
    private String groupCreateDate;
    private String groupWithdrawalDate;
    private String groupComment;
    private String groupStatus;
}
