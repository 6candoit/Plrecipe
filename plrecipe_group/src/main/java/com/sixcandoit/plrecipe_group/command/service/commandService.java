package com.sixcandoit.plrecipe_group.command.service;

import com.sixcandoit.plrecipe_group.command.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.command.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.command.vo.RequestGroup;

public interface commandService {

    void registGroup(GroupDTO groupDTO);

    GroupEntity modifyGroup(int groupId, RequestGroup requestGroup);

    GroupEntity modifyGroupChangeStatus(int groupId, RequestGroup requestGroup);
}
