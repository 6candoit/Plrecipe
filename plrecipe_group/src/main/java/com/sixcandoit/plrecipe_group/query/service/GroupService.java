package com.sixcandoit.plrecipe_group.query.service;


import com.sixcandoit.plrecipe_group.query.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.query.dto.GroupMemberDTO;
import com.sixcandoit.plrecipe_group.query.vo.GroupMember;

import java.util.List;

public interface GroupService {
    List<GroupDTO> selectAllGroup();

    List<GroupMember> selectMembersByGroupId(int groupId);

    List<GroupMemberDTO> getGroupMemberDTOList(List<GroupMember> groupMembers);

    List<GroupDTO> selectPublicOrPrivateGroup(int memberId);
}
