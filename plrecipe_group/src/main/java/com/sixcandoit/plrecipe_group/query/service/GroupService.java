package com.sixcandoit.plrecipe_group.query.service;


import com.sixcandoit.plrecipe_group.query.dto.GroupDTO;
import java.util.List;

public interface GroupService {
    List<GroupDTO> selectAllGroup();

    List<GroupDTO> selectPublicOrPrivateGroup(int memberId);
}
