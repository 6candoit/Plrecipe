package com.sixcandoit.plrecipe_post.aggregate;

import jakarta.persistence.*;

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

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "is_post_public")
    private String isPostPublic;

    @Column(name = "member_count")
    @Enumerated(EnumType.STRING)
    private MemberCount memberCount;

    public Post() {
    }

    public Post(int postId, String postTitle, String postContent, String postDate, String postDeleteDate, String memberEmail, int courseId, String isPostPublic, MemberCount memberCount) {
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

    public String getIsPostPublic() {
        return isPostPublic;
    }

    public void setIsPostPublic(String isPostPublic) {
        this.isPostPublic = isPostPublic;
    }

    public MemberCount getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(MemberCount memberCount) {
        this.memberCount = memberCount;
    }

    @Override
    public String toString() {
        return "Post{" +
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
