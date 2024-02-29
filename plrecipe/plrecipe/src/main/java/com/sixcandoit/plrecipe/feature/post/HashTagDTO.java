package com.sixcandoit.plrecipe.feature.post;

public class HashTagDTO {
    private int hashtagId;
    private String hashtagTitle;

    public HashTagDTO() {
    }

    public HashTagDTO(int hashtagId, String hashtagTitle) {
        this.hashtagId = hashtagId;
        this.hashtagTitle = hashtagTitle;
    }

    public int getHashtagId() {
        return hashtagId;
    }

    public void setHashtagId(int hashtagId) {
        this.hashtagId = hashtagId;
    }

    public String getHashtagTitle() {
        return hashtagTitle;
    }

    public void setHashtagTitle(String hashtagTitle) {
        this.hashtagTitle = hashtagTitle;
    }

    @Override
    public String toString() {
        return "HashTagDTO{" +
                "hashtagId=" + hashtagId +
                ", hashtagTitle='" + hashtagTitle + '\'' +
                '}';
    }
}
