package com.sixcandoit.plrecipe_group.query.vo;

import com.sixcandoit.plrecipe_group.query.dto.GroupInvite;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GroupMember {


    private int groupMemberId;


    private int groupMemberSequence;


    private GroupInvite inviteStateId;


    private int groupId;


    private int memberId;
}
