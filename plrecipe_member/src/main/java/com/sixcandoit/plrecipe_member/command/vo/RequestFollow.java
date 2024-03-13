package com.sixcandoit.plrecipe_member.command.vo;

import lombok.Data;

@Data
public class RequestFollow {

    private int followId;
    private int userFollow;
    private int userFollower;
}
