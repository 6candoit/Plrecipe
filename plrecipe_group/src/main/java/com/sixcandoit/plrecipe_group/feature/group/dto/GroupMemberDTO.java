package com.sixcandoit.plrecipe_group.feature.group.dto;

import com.sixcandoit.plrecipe_group.feature.group.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.feature.group.vo.Member;
import com.sixcandoit.plrecipe_group.feature.group.vo.ResponseMember;
import lombok.*;

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
    private GroupDTO groupId;
    private MemberDTO memberId;

//    private ResponseMember member;
}
