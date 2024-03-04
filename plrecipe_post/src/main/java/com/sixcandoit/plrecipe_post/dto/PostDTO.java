package com.sixcandoit.plrecipe_post.dto;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PostDTO {
    private int postId;
    private String postTitle;
    private String postContent;
    private String postDate;
    private String postDeleteDate;
    private int memberId;
    private int courseId;
    private String isPostPublic;
    private MemberCount memberCount;


}