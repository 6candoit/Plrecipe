package com.sixcandoit.plrecipe_group.command.repository;


import com.sixcandoit.plrecipe_group.command.dto.GroupInvite;
import com.sixcandoit.plrecipe_group.command.vo.MemberEntity;
import com.sixcandoit.plrecipe_group.command.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.command.vo.GroupMember;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GroupMemberRepository extends JpaRepository<GroupMember,Integer> {
    @Query("SELECT MAX(gm.groupMemberSequence) FROM GroupMember gm WHERE gm.groupId = :groupId")
    Integer findMaxSequenceByGroupId(@Param("groupId") GroupEntity groupId);

    @Modifying
    @Query("UPDATE GroupMember gm SET gm.inviteStateId = :newState WHERE gm.groupId = :groupEntity AND gm.memberId = :memberEntity")
    void updateInviteStateByGroupAndMember(@Param("groupEntity") GroupEntity groupEntity, @Param("memberEntity") MemberEntity memberEntity, @Param("newState") GroupInvite newState);


}
