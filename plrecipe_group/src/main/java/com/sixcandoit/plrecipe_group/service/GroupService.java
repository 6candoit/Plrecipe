package com.sixcandoit.plrecipe_group.service;

import com.sixcandoit.plrecipe_group.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.dto.MemberDTO;
import com.sixcandoit.plrecipe_group.repository.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private GroupMapper groupMapper;

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
}
