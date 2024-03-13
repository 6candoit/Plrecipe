package com.sixcandoit.plrecipe_group.command.dto;
import com.sixcandoit.plrecipe_group.command.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.command.dto.GroupInvite;
import com.sixcandoit.plrecipe_group.command.dto.MemberDTO;
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

//    private List<ResponseMember> members;
//
//    private GroupDTO groupDTO;
//    private MemberDTO memberDTO;
}
