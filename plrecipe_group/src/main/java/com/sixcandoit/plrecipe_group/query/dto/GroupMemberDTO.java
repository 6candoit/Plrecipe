package com.sixcandoit.plrecipe_group.query.dto;

import com.sixcandoit.plrecipe_group.query.vo.ResponseMember;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GroupMemberDTO {

    private int groupMemberId;
    private int groupMemberSequence;
    private GroupInvite inviteStateId;
    private int groupId;
    private List<ResponseMember> members = new ArrayList<>();;

    public int getGroupMemberId() {
        return groupMemberId;
    }

    public int getGroupMemberSequence() {
        return groupMemberSequence;
    }

    public GroupInvite getInviteStateId() {
        return inviteStateId;
    }

    public int getGroupId() {
        return groupId;
    }

    public List<ResponseMember> getMembers() {
        return members;
    }

    public void setGroupMemberId(int groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public void setGroupMemberSequence(int groupMemberSequence) {
        this.groupMemberSequence = groupMemberSequence;
    }

    public void setInviteStateId(GroupInvite inviteStateId) {
        this.inviteStateId = inviteStateId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setMembers(List<ResponseMember> members) {
        this.members = members;
    }
}