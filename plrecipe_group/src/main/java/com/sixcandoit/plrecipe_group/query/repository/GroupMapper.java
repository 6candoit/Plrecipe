package com.sixcandoit.plrecipe_group.query.repository;

import com.sixcandoit.plrecipe_group.query.vo.GroupMember;
import com.sixcandoit.plrecipe_group.query.dto.GroupDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface GroupMapper {

    List<GroupDTO> selectAllGroup();

    List<GroupDTO> selectPublicOrPrivateGroup(int memberId);
    List<GroupMember> selectMembersByGroupId(int groupId);



}
