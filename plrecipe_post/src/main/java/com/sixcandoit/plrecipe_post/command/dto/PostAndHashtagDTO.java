package com.sixcandoit.plrecipe_post.command.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostAndHashtagDTO {
    private int postHashtagId;
    private int hashtagId;
    private int postId;

    public PostAndHashtagDTO(int hashtagId, int postId) {
        this.hashtagId = hashtagId;
        this.postId = postId;
    }
}
