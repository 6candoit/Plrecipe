package com.sixcandoit.plrecipe_post.vo;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.vo.hashtag.Hashtag;
import lombok.Data;

import java.util.List;

@Data
public class RequestTest {
    private Post post;
//    private String postTitle;
//    private String postContent;
//    private String postDate;
//    private int memberId;
//    private int courseId;
//    private String isPostPublic;
//    private MemberCount memberCount;
//    private List<Integer> hashtagId;
    private List<Integer> hashtagId;
}
