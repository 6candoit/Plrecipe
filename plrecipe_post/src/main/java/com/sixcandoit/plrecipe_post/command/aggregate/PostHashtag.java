package com.sixcandoit.plrecipe_post.command.aggregate;

import jakarta.persistence.*;

@Entity(name = "plrecipe_postHashtag")
@Table(name = "post_hashtag")
public class PostHashtag {

    @Id
    @Column(name = "post_hashtag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postHashtagId;

    @Column(name = "hashtag_id")
    private int hashtagId;

    @Column(name = "post_id")
    private int postId;

    public PostHashtag() {
    }

    public PostHashtag(int postHashtagId, int hashtagId, int postId) {
        this.postHashtagId = postHashtagId;
        this.hashtagId = hashtagId;
        this.postId = postId;
    }


    public int getPostHashtagId() {
        return postHashtagId;
    }

    public void setPostHashtagId(int postHashtagId) {
        this.postHashtagId = postHashtagId;
    }

    public int getHashtagId() {
        return hashtagId;
    }

    public void setHashtagId(int hashtagId) {
        this.hashtagId = hashtagId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "PostHashtag{" +
                "postHashtagId=" + postHashtagId +
                ", hashtagId=" + hashtagId +
                ", postId=" + postId +
                '}';
    }
}
