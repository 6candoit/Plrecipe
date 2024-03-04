package com.sixcandoit.plrecipe_post.dto;

public class PostLikeDTO {
    private int postLikeId;
    private String memberEmail;
    private int postId;

    public PostLikeDTO() {
    }

    public PostLikeDTO(int postLikeId, String memberEmail, int postId) {
        this.postLikeId = postLikeId;
        this.memberEmail = memberEmail;
        this.postId = postId;
    }

    public int getPostLikeId() {
        return postLikeId;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public int getPostId() {
        return postId;
    }

    @Override
    public String toString() {
        return "PostLikeDTO{" +
                "postLikeId=" + postLikeId +
                ", memberEmail='" + memberEmail + '\'' +
                ", postId=" + postId +
                '}';
    }
}
