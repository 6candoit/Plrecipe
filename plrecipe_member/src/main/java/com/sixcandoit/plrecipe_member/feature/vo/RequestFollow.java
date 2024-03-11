package com.sixcandoit.plrecipe_member.feature.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestFollow {

    private int followId;
    private int userFollow;
    private int userFollower;
}
