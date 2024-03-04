package com.sixcandoit.plrecipe_group.aggregate;

import jakarta.persistence.*;

@Entity(name= "plrecipe-group")
@Table(name = "plrecipe_group")
public class Group {

    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    @Column(name="group_name")
    private String groupName;
    @Column(name="is_group_public")
    private String isGroupPublic;
    @Column(name="group_create_date")
    private String groupCreateDate;
    @Column(name="group_withdrawal_date")
    private String groupWithdrawalDate;
    @Column(name="group_comment")
    private String groupComment;
    @Column(name="group_status")
    private String groupStatus;

    public Group() {
    }

    public Group(int groupId, String groupName, String isGroupPublic, String groupCreateDate, String groupWithdrawalDate, String groupComment, String groupStatus) {
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

    public String getIsGroupPublic() {
        return isGroupPublic;
    }

    public void setIsGroupPublic(String isGroupPublic) {
        this.isGroupPublic = isGroupPublic;
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

    public String getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", isGroupPublic='" + isGroupPublic + '\'' +
                ", groupCreateDate='" + groupCreateDate + '\'' +
                ", groupWithdrawalDate='" + groupWithdrawalDate + '\'' +
                ", groupComment='" + groupComment + '\'' +
                ", groupStatus='" + groupStatus + '\'' +
                '}';
    }
}