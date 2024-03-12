package com.sixcandoit.plrecipe_post.query.aggregate;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostLike {

    private int postHashtagId;
    private int memberId;

    private int postId;
}
