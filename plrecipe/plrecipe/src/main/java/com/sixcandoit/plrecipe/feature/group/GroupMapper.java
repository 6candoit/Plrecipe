package com.sixcandoit.plrecipe.feature.group;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper {
    List<GroupDTO> selectAllGroup();
}
