package com.sixcandoit.plrecipe_post.dto;

public class PostHashtagDTO {
    private PostDTO postDTO;
    private HashtagDTO hashtagDTO;

    public PostHashtagDTO() {
    }

    public PostHashtagDTO(PostDTO postDTO, HashtagDTO hashtagDTO) {
        this.postDTO = postDTO;
        this.hashtagDTO = hashtagDTO;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public HashtagDTO getHashtagDTO() {
        return hashtagDTO;
    }

    @Override
    public String toString() {
        return "PostHashtagDTO{" +
                "postDTO=" + postDTO +
                ", hashtagDTO=" + hashtagDTO +
                '}';
    }
}
