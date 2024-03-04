package com.sixcandoit.plrecipe_member.aggregate;

import jakarta.persistence.*;

@Entity(name = "plrecipe_follow")
@Table(name = "follow_info")
public class Follow {

    @Id
    @Column(name = "follow_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int followId;

    @Column(name = "user_follow")
    private int userFollow;

    @Column(name = "user_follower")
    private int userFollower;

    public Follow() {
    }

    public Follow(int followId, int userFollow, int userFollower) {
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

    public int getUserFollow() {
        return userFollow;
    }

    public void setUserFollow(int userFollow) {
        this.userFollow = userFollow;
    }

    public int getUserFollower() {
        return userFollower;
    }

    public void setUserFollower(int userFollower) {
        this.userFollower = userFollower;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "followId=" + followId +
                ", userFollow=" + userFollow +
                ", userFollower=" + userFollower +
                '}';
    }
}
