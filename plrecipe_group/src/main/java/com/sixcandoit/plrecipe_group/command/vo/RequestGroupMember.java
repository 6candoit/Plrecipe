package com.sixcandoit.plrecipe_group.command.vo;

import com.sixcandoit.plrecipe_group.command.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.command.dto.GroupInvite;
import com.sixcandoit.plrecipe_group.command.dto.MemberDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestGroupMember {
    private int groupMemberId;
    private int groupMemberSequence;
    private GroupInvite inviteStateId;
    private GroupDTO groupId;
    private MemberDTO memberId;
}
