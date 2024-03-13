package com.sixcandoit.plrecipe_post.command.aggregate;

import jakarta.persistence.*;

@Entity(name = "plrecipe_hashtag")
@Table(name = "hashtag")
public class Hashtag {
    @Id
    @Column(name = "hashtag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hashtagId;

    @Column(name = "hashtag_title")
    private String hashtagTitle;

    public Hashtag() {
    }

    public Hashtag(int hashtagId, String hashtagTitle) {
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
        return "Hashtag{" +
                "hashtagId=" + hashtagId +
                ", hashtagTitle='" + hashtagTitle + '\'' +
                '}';
    }
}
