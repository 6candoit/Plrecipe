package com.sixcandoit.plrecipe.feature.post.dto;

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

    public void setPostLikeId(int postLikeId) {
        this.postLikeId = postLikeId;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
