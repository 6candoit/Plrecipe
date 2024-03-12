package com.sixcandoit.plrecipe_post.query.aggregate;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostHashtag {
    private int postHashtagId;
    private int hashtagId;
    private int postId;
}
