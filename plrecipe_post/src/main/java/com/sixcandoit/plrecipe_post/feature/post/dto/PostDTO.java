package com.sixcandoit.plrecipe_post.feature.post.dto;

import com.sixcandoit.plrecipe_post.feature.post.MemberCount;

public class PostDTO {
    private int postId;
    private String postTitle;
    private String postContent;
    private String postDate;
    private String postDeleteDate;
    private String memberEmail;
    private int courseId;
    private String isPostPublic;
    private MemberCount memberCount;

    public PostDTO() {
    }

    public PostDTO(int postId, String postTitle, String postContent, String postDate, String postDeleteDate, String memberEmail, int courseId, String isPostPublic, MemberCount memberCount) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postDate = postDate;
        this.postDeleteDate = postDeleteDate;
        this.memberEmail = memberEmail;
        this.courseId = courseId;
        this.isPostPublic = isPostPublic;
        this.memberCount = memberCount;
    }

    public int getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getPostDeleteDate() {
        return postDeleteDate;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getIsPostPublic() {
        return isPostPublic;
    }

    public MemberCount getMemberCount() {
        return memberCount;
    }



    @Override
    public String toString() {
        return "PostDTO{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postDate='" + postDate + '\'' +
                ", postDeleteDate='" + postDeleteDate + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", courseId=" + courseId +
                ", isPostPublic='" + isPostPublic + '\'' +
                ", memberCount=" + memberCount +
                '}';
    }
}
