package com.sixcandoit.plrecipe_member.feature.vo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponsePost {

    private int postId;
    private String postTitle;
    private String postDate;
    private String postDeleteDate;
    private int memberId;
    private int courseId;
    private String isPostPublic;
    private MemberCount memberCount;

    private List<ResponsePost> posts;

}
