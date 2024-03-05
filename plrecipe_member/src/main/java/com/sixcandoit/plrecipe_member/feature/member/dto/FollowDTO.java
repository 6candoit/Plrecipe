package com.sixcandoit.plrecipe_member.feature.member.dto;

public class FollowDTO {

    private int followId;
    private int userFollow;
    private int userFollower;

    public FollowDTO() {
    }

    public FollowDTO(int followId, int userFollow, int userFollower) {
        this.followId = followId;
        this.userFollow = userFollow;
        this.userFollower = userFollower;
    }

    public int getFollowId() {
        return followId;
    }

    public int getUserFollow() {
        return userFollow;
    }

    public int getUserFollower() {
        return userFollower;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public void setUserFollow(int userFollow) {
        this.userFollow = userFollow;
    }

    public void setUserFollower(int userFollower) {
        this.userFollower = userFollower;
    }

    @Override
    public String toString() {
        return "FollowDTO{" +
                "followId=" + followId +
                ", userFollow=" + userFollow +
                ", userFollower=" + userFollower +
                '}';
    }
}
