package com.sixcandoit.plrecipe_post.command.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostAndHashtag {

    @Id
    @Column(name = "post_hashtag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postHashtagId;

    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "hashtag_id")
    @ElementCollection
    private List<Integer> hashtagId;


}
