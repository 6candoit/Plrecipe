package com.sixcandoit.plrecipe_post.query.dto;

import com.sixcandoit.plrecipe_post.query.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.query.vo.ResponseMember;
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

    private ResponseMember member;
}
