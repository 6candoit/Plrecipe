package com.sixcandoit.plrecipe_group.command.service;

import org.springframework.transaction.annotation.Transactional;

public interface commandMemberService {
    void withdrawalGroup(int group_member_id);


    void invitedToGroup(int groupId, int memberId);

    @Transactional
    void acceptGroupInvitation(int groupId, int memberId);

}
