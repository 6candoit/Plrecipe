package com.sixcandoit.plrecipe_member.dto;

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

    @Override
    public String toString() {
        return "FollowDTO{" +
                "followId=" + followId +
                ", userFollow=" + userFollow +
                ", userFollower=" + userFollower +
                '}';
    }
}
