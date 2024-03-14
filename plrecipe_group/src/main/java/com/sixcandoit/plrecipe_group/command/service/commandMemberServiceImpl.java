package com.sixcandoit.plrecipe_group.command.service;

import com.sixcandoit.plrecipe_group.command.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.command.dto.GroupInvite;
import com.sixcandoit.plrecipe_group.command.repository.GroupMemberRepository;
import com.sixcandoit.plrecipe_group.command.repository.GroupRepository;
import com.sixcandoit.plrecipe_group.command.repository.MemberRepository;
import com.sixcandoit.plrecipe_group.command.vo.GroupMember;


import com.sixcandoit.plrecipe_group.command.vo.MemberEntity;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class commandMemberServiceImpl implements commandMemberService{
    private final GroupMemberRepository groupMemberRepository;
    private final ModelMapper mapper;
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public commandMemberServiceImpl(GroupMemberRepository groupMemberRepository, ModelMapper mapper, GroupRepository groupRepository, MemberRepository memberRepository) {
        this.groupMemberRepository = groupMemberRepository;
        this.mapper = mapper;
        this.groupRepository = groupRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void withdrawalGroup(int group_member_id){
        groupMemberRepository.deleteById(group_member_id);
    }

    @Transactional
    @Override
    public void invitedToGroup(int groupId, int memberId) {
        // 예를 들어, groupId와 memberId를 사용하여 GroupEntity 및 MemberEntity를 가져오는 로직
        GroupEntity groupEntity = groupRepository.findById(groupId).orElseThrow(() -> new EntityNotFoundException("Group not found"));
        MemberEntity memberEntity = memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException("Member not found"));

        GroupMember groupMember = new GroupMember();
        groupMember.setGroupId(groupEntity);
        groupMember.setMemberId(memberEntity);

        Integer maxSequence = groupMemberRepository.findMaxSequenceByGroupId(groupEntity);
        int newSequence = (maxSequence != null) ? maxSequence + 1 : 1;
        groupMember.setGroupMemberSequence(newSequence);
        groupMember.setInviteStateId(GroupInvite.WAITING);

        groupMemberRepository.save(groupMember);
    }


    @Transactional
    @Override
    public void acceptGroupInvitation(int groupId, int memberId) {
        GroupEntity groupEntity = groupRepository.findById(groupId).orElseThrow(() -> new EntityNotFoundException("Group not found"));
        MemberEntity memberEntity = memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException("Member not found"));

        groupMemberRepository.updateInviteStateByGroupAndMember(groupEntity, memberEntity, GroupInvite.ACCEPT);
    }
}
