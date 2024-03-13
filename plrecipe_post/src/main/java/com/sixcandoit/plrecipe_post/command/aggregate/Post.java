package com.sixcandoit.plrecipe_post.command.aggregate;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "plrecipe_post")
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "post_date")
    private String postDate;

    @Column(name = "post_delete_date")
    private String postDeleteDate;

    @Column(name = "member_id")
    private int memberId;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "is_post_public")
    private String isPostPublic;

    @Column(name = "member_count")
    @Enumerated(EnumType.STRING)
    private MemberCount memberCount;

}