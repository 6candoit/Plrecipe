package com.sixcandoit.plrecipe_post.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostLikeDTO {
    private int postLikeId;
    private int memberId;
    private int postId;


}
