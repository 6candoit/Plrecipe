package com.sixcandoit.plrecipe_member.command.vo;

import lombok.Data;

@Data
public class ResponseFollow {
    private int followId;
    private int userFollow;
    private int userFollower;
}
