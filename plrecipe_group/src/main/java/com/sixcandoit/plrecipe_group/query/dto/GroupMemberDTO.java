package com.sixcandoit.plrecipe_group.query.dto;
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
    private int groupId;
    private int memberId;

//    private List<ResponseMember> members;
//
//    private GroupDTO groupDTO;
//    private MemberDTO memberDTO;
}
