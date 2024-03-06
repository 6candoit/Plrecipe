package com.sixcandoit.plrecipe_post.dto;

import lombok.Data;

@Data
public class PostHashtagDTO {
    private int postHashtagId;
    private int hashtagId;
    private int postId;

    public PostHashtagDTO(int hashtagId, int postId) {
        this.hashtagId = hashtagId;
        this.postId = postId;
    }
}
