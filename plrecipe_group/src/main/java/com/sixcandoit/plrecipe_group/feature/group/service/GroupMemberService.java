package com.sixcandoit.plrecipe_group.feature.group.service;


import org.springframework.transaction.annotation.Transactional;

public interface GroupMemberService {

   void withdrawalGroup(int group_member_id);


   void invitedToGroup(int groupId, int memberId);

   @Transactional
   void acceptGroupInvitation(int groupId, int memberId);
}
