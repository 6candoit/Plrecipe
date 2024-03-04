package com.sixcandoit.plrecipe_group.repository.mapper;

import com.sixcandoit.plrecipe_group.aggregate.Group;
import com.sixcandoit.plrecipe_group.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper {
    List<GroupDTO> selectAllGroup();

    List<MemberDTO> selectMembersByGroupId(int groupId);

    List<GroupDTO> selectPublicOrPrivateGroup(int memberId);

}
