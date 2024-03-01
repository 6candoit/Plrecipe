package com.sixcandoit.plrecipe_member.feature.follow.dto;

public class FollowDTO {

    private int followId;
    private String userFollow;
    private String userFollower;

    public FollowDTO() {
    }

    public FollowDTO(int followId, String userFollow, String userFollower) {
        this.followId = followId;
        this.userFollow = userFollow;
        this.userFollower = userFollower;
    }

    public int getFollowId() {
        return followId;
    }

    public String getUserFollow() {
        return userFollow;
    }

    public String getUserFollower() {
        return userFollower;
    }

    @Override
    public String toString() {
        return "FollowDTO{" +
                "followId=" + followId +
                ", userFollow='" + userFollow + '\'' +
                ", userFollower='" + userFollower + '\'' +
                '}';
    }
}
