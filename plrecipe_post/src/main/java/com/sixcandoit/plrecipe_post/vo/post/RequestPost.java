package com.sixcandoit.plrecipe_post.vo.post;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import lombok.Data;

@Data
public class RequestPost {
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
