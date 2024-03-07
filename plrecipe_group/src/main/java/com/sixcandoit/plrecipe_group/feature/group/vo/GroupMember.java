package com.sixcandoit.plrecipe_group.feature.group.vo;

import com.sixcandoit.plrecipe_group.feature.group.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.feature.group.dto.GroupInvite;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "group_member")
@Data
public class GroupMember {

    @Id
    @Column(name="group_member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupMemberId;

    @Column(name = "groupmember_sequence")
    private int groupMemberSequence;

    @Column(name="invite_state_id")
    @Enumerated(EnumType.STRING)
    private GroupInvite inviteStateId;

    @ManyToOne
    @JoinColumn(name="group_id")
    private GroupEntity groupId;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member memberId;
}
