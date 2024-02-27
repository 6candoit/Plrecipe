package com.sixcandoit.plrecipe.feature.group;

public class GroupDTO {

    private int groupId;
    private String groupName;
    private boolean isGroupPublic;
    private String groupCreateDate;
    private String groupWithdrawalDate;
    private String groupComment;
    private boolean groupStatus;

    public GroupDTO() {
    }

    public GroupDTO(int groupId, String groupName, boolean isGroupPublic, String groupCreateDate, String groupWithdrawalDate, String groupComment, boolean groupStatus) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.isGroupPublic = isGroupPublic;
        this.groupCreateDate = groupCreateDate;
        this.groupWithdrawalDate = groupWithdrawalDate;
        this.groupComment = groupComment;
        this.groupStatus = groupStatus;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isGroupPublic() {
        return isGroupPublic;
    }

    public void setGroupPublic(boolean groupPublic) {
        isGroupPublic = groupPublic;
    }

    public String getGroupCreateDate() {
        return groupCreateDate;
    }

    public void setGroupCreateDate(String groupCreateDate) {
        this.groupCreateDate = groupCreateDate;
    }

    public String getGroupWithdrawalDate() {
        return groupWithdrawalDate;
    }

    public void setGroupWithdrawalDate(String groupWithdrawalDate) {
        this.groupWithdrawalDate = groupWithdrawalDate;
    }

    public String getGroupComment() {
        return groupComment;
    }

    public void setGroupComment(String groupComment) {
        this.groupComment = groupComment;
    }

    public boolean isGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(boolean groupStatus) {
        this.groupStatus = groupStatus;
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", isGroupPublic=" + isGroupPublic +
                ", groupCreateDate='" + groupCreateDate + '\'' +
                ", groupWithdrawalDate='" + groupWithdrawalDate + '\'' +
                ", groupComment='" + groupComment + '\'' +
                ", groupStatus=" + groupStatus +
                '}';
    }
}
