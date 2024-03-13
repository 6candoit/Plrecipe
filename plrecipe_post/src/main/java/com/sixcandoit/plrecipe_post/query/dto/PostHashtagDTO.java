package com.sixcandoit.plrecipe_post.query.dto;

import com.sixcandoit.plrecipe_post.query.dto.HashtagDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostHashtagDTO {
    private int postHashtagId;
    private PostDTO postDTO;
    private HashtagDTO hashtagDTO;

}
