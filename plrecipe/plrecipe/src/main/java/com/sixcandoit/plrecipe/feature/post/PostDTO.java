package com.sixcandoit.plrecipe.feature.post;

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

    public MemberCount getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(MemberCount memberCount) {
        this.memberCount = memberCount;
    }

    public PostDTO() {
    }

    public PostDTO(int postId, String postTitle, String postContent, String postDate, String postDeleteDate, String memberEmail, int courseId, String isPostPublic) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postDate = postDate;
        this.postDeleteDate = postDeleteDate;
        this.memberEmail = memberEmail;
        this.courseId = courseId;
        this.isPostPublic = isPostPublic;
//        this.memberCount = memberCount;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostDeleteDate() {
        return postDeleteDate;
    }

    public void setPostDeleteDate(String postDeleteDate) {
        this.postDeleteDate = postDeleteDate;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String isPostPublic() {
        return isPostPublic;
    }

    public void setPostPublic(String postPublic) {
        isPostPublic = postPublic;
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
                ", isPostPublic=" + isPostPublic +
                ", memberCount=" + memberCount +
                '}';
    }
}
