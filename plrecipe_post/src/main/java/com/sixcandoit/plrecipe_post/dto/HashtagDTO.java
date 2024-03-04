package com.sixcandoit.plrecipe_post.dto;

import lombok.Setter;

public class HashtagDTO {
    private int hashtagId;
    private String hashtagTitle;

    public HashtagDTO() {
    }

    public HashtagDTO(int hashtagId, String hashtagTitle) {
        this.hashtagId = hashtagId;
        this.hashtagTitle = hashtagTitle;
    }

    public int getHashtagId() {
        return hashtagId;
    }

    public String getHashtagTitle() {
        return hashtagTitle;
    }



    @Override
    public String toString() {
        return "HashtagDTO{" +
                "hashtagId=" + hashtagId +
                ", hashtagTitle='" + hashtagTitle + '\'' +
                '}';
    }
}
