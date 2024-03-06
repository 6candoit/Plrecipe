package com.sixcandoit.plrecipe_post.dto;

import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.vo.hashtag.Hashtag;

public class PostHashtagDTO {
    private int postHashtagId;
    private Post post;
    private Hashtag hashtag;

    public PostHashtagDTO() {
    }

    public PostHashtagDTO(int postHashtagId, Post post, Hashtag hashtag) {
        this.postHashtagId = postHashtagId;
        this.post = post;
        this.hashtag = hashtag;
    }

    public int getPostHashtagId() {
        return postHashtagId;
    }

    public void setPostHashtagId(int postHashtagId) {
        this.postHashtagId = postHashtagId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Hashtag getHashtag() {
        return hashtag;
    }

    public void setHashtag(Hashtag hashtag) {
        this.hashtag = hashtag;
    }

    @Override
    public String toString() {
        return "PostHashtagDTO{" +
                "postHashtagId=" + postHashtagId +
                ", post=" + post +
                ", hashtag=" + hashtag +
                '}';
    }
}
