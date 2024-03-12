package com.sixcandoit.plrecipe_post.command.vo;

import com.sixcandoit.plrecipe_post.command.aggregate.Post;
import com.sixcandoit.plrecipe_post.query.vo.ResponseMember;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponsePostHashtag {
    private Post post;
    private List<Integer> hashtagId;
    private List<ResponseMember> member;
}
