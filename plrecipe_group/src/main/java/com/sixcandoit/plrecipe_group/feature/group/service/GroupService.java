package com.sixcandoit.plrecipe_group.feature.group.service;

import com.sixcandoit.plrecipe_group.feature.group.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.feature.group.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.feature.group.dto.MemberDTO;
import com.sixcandoit.plrecipe_group.feature.group.vo.RequestGroup;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GroupService {
    List<GroupDTO> selectAllGroup();

    List<MemberDTO> selectMembersByGroupId(int groupId);

    List<GroupDTO> selectPublicOrPrivateGroup(int memberId);

    void registGroup(GroupDTO groupDTO);

     GroupEntity modifyGroup(int groupId, RequestGroup requestGroup);

     GroupEntity modifyGroupChangeStatus(int groupId, RequestGroup requestGroup);


}
