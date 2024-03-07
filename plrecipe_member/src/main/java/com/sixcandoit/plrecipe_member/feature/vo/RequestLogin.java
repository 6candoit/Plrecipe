package com.sixcandoit.plrecipe_member.feature.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestLogin {
    private String memberEmail;
    private String password;
}
