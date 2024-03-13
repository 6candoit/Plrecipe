package com.sixcandoit.plrecipe_post.command.vo;

import com.sixcandoit.plrecipe_post.command.aggregate.Post;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestPostHashtag {
    private Post post;
    private List<Integer> hashtagId;
}
