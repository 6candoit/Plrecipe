package com.sixcandoit.plrecipe_group.query.service;

import com.sixcandoit.plrecipe_group.query.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.query.repository.GroupMapper;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GroupServiceimpl implements GroupService {

    private final ModelMapper mapper;
    private GroupMapper groupMapper;

    @Autowired
    public GroupServiceimpl(ModelMapper mapper, GroupMapper groupMapper) {
        this.mapper = mapper;
        this.groupMapper = groupMapper;
    }

    @Override
    public List<GroupDTO> selectAllGroup() {
        return groupMapper.selectAllGroup();
    }

//    public List<MemberDTO> selectMembersByGroupId(int groupId) {
//        return groupMapper.selectMembersByGroupId(groupId);
//    }

    @Override
    public List<GroupDTO> selectPublicOrPrivateGroup(int memberId){
        return groupMapper.selectPublicOrPrivateGroup(memberId);
    }

}
