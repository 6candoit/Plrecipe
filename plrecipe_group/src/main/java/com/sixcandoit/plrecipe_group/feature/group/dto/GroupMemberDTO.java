package com.sixcandoit.plrecipe_group.feature.group.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GroupMemberDTO {

    private int groupMemberId;
    private int groupMemberSequence;
    private GroupInvite inviteStateId;
    private GroupDTO groupId;
    private MemberDTO memberId;

}
