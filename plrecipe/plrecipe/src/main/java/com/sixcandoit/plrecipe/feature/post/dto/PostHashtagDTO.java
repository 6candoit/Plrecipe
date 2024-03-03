package com.sixcandoit.plrecipe.feature.post.dto;

import com.sixcandoit.plrecipe.feature.post.dto.HashTagDTO;
import com.sixcandoit.plrecipe.feature.post.dto.PostDTO;

public class PostHashtagDTO {
    private PostDTO postDTO;
    private HashTagDTO hashTagDTO;

    public PostHashtagDTO() {
    }

    public PostHashtagDTO(PostDTO postDTO, HashTagDTO hashTagDTO) {
        this.postDTO = postDTO;
        this.hashTagDTO = hashTagDTO;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public HashTagDTO getHashTagDTO() {
        return hashTagDTO;
    }

    public void setHashTagDTO(HashTagDTO hashTagDTO) {
        this.hashTagDTO = hashTagDTO;
    }

    @Override
    public String toString() {
        return "PostHashtagDTO{" +
                "postDTO=" + postDTO +
                ", hashTagDTO=" + hashTagDTO +
                '}';
    }
}
