package com.sixcandoit.plrecipe.feature.group;

import com.sixcandoit.plrecipe.feature.member.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper {
    List<GroupDTO> selectAllGroup();

    List<MemberDTO> selectMembersByGroupId(int groupId);

    List<GroupDTO> selectPublicOrPrivateGroup(String memberEmail);

}
