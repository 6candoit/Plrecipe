package com.sixcandoit.plrecipe_post.command.dto;

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
