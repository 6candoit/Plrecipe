package com.sixcandoit.plrecipe_group.feature.group.vo;

import com.sixcandoit.plrecipe_group.feature.group.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.feature.group.dto.GroupInvite;
import com.sixcandoit.plrecipe_group.feature.group.dto.MemberDTO;
import lombok.Data;

@Data
public class ResponseGroupMember {
    private int groupMemberId;
    private int groupMemberSequence;
    private GroupInvite inviteStateId;
    private GroupDTO groupId;
    private MemberDTO memberId;

}
