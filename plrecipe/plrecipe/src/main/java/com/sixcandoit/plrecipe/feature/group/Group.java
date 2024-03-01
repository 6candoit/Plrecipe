package com.sixcandoit.plrecipe.feature.group;

import com.sixcandoit.plrecipe.feature.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Group {

    private GroupMapper groupMapper;

    @Autowired
    public Group(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    public List<GroupDTO> selectAllGroup() {
        return groupMapper.selectAllGroup();
    }


    public List<MemberDTO> selectMembersByGroupId(int groupId) {
        return groupMapper.selectMembersByGroupId(groupId);

//    public List<GroupDTO> selectPublicOrPrivateGroup(String memberEmail){
//        return groupMapper.selectPublicOrPrivateGroup(memberEmail);
//
//    }
    }
}