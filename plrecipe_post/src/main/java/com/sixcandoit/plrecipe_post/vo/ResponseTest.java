package com.sixcandoit.plrecipe_post.vo;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import lombok.Data;

@Data
public class ResponseTest {
    private String postTitle;
    private String postContent;
    private String postDate;
    private int memberId;
    private int courseId;
    private String isPostPublic;
    private MemberCount memberCount;
    private int hashtagId;
}
