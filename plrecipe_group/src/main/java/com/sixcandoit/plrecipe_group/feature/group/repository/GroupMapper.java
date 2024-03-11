package com.sixcandoit.plrecipe_group.feature.group.repository;

import com.sixcandoit.plrecipe_group.feature.group.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.feature.group.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.feature.group.dto.MemberDTO;
import com.sixcandoit.plrecipe_group.feature.group.vo.GroupMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper {
    List<GroupDTO> selectAllGroup();

    List<GroupDTO> selectPublicOrPrivateGroup(int memberId);

    List<GroupMember> selectMembersByGroupId(int groupId);

}
