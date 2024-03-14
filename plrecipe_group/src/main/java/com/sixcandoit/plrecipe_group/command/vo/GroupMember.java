package com.sixcandoit.plrecipe_group.command.vo;

import com.sixcandoit.plrecipe_group.command.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.command.dto.GroupInvite;
import com.sixcandoit.plrecipe_group.command.vo.MemberEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "group_member", uniqueConstraints = @UniqueConstraint(columnNames = { "groupId", "memberId" }))
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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
    private MemberEntity memberId;
}
