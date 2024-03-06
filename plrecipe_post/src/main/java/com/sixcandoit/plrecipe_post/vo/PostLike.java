package com.sixcandoit.plrecipe_post.vo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "post_like")
public class PostLike {

    @Id
    @Column(name = "post_hashtag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postHashtagId;

    @Column(name = "member_id")
    private int memberId;

    @Column(name = "post_id")
    private int postId;
}
