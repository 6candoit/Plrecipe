package com.sixcandoit.plrecipe_member.aggregate;

import jakarta.persistence.*;

@Entity(name = "plrecipe_follow")
@Table(name = "follow")
public class Follow {

    @Id
    @Column(name = "follow_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int followId;

    @Column(name = "user_follow")
    private String userFollow;

    @Column(name = "user_follower")
    private String userFollower;

    public Follow() {
    }

    public Follow(int followId, String userFollow, String userFollower) {
        this.followId = followId;
        this.userFollow = userFollow;
        this.userFollower = userFollower;
    }

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public String getUserFollow() {
        return userFollow;
    }

    public void setUserFollow(String userFollow) {
        this.userFollow = userFollow;
    }

    public String getUserFollower() {
        return userFollower;
    }

    public void setUserFollower(String userFollower) {
        this.userFollower = userFollower;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "followId=" + followId +
                ", userFollow='" + userFollow + '\'' +
                ", userFollower='" + userFollower + '\'' +
                '}';
    }
}
