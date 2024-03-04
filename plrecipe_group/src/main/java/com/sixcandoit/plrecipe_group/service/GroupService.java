package com.sixcandoit.plrecipe_group.service;

import com.sixcandoit.plrecipe_group.aggregate.Group;
import com.sixcandoit.plrecipe_group.aggregate.GroupMember;
import com.sixcandoit.plrecipe_group.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.dto.MemberDTO;
import com.sixcandoit.plrecipe_group.repository.mapper.GroupMapper;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private GroupMapper groupMapper;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public GroupService(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    public List<GroupDTO> selectAllGroup() {
        return groupMapper.selectAllGroup();
    }


    public List<MemberDTO> selectMembersByGroupId(int groupId) {
        return groupMapper.selectMembersByGroupId(groupId);

    }

    public List<GroupDTO> selectPublicOrPrivateGroup(int memberId){
        return groupMapper.selectPublicOrPrivateGroup(memberId);

    }

    @Transactional
    public GroupDTO createGroup(String groupName) {
        GroupDTO group = new GroupDTO();
        group.setGroupName(groupName);

        entityManager.persist(group);

        return group;
    }

    @Transactional
    public void addUserToGroup(int memberId, Group group) {
        GroupMember membership = new GroupMember();
        membership.setMemberId(memberId);
        membership.setGroup(group);

        entityManager.persist(membership);
    }
}
