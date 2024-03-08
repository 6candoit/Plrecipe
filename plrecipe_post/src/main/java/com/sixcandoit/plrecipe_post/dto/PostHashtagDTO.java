package com.sixcandoit.plrecipe_post.dto;

import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.vo.hashtag.Hashtag;
import lombok.Data;

@Data
public class PostHashtagDTO {
    private int postHashtagId;
    private PostDTO postDTO;
    private HashtagDTO hashtagDTO;

}
