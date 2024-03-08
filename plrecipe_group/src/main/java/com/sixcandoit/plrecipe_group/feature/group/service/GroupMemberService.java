package com.sixcandoit.plrecipe_group.feature.group.service;


import com.sixcandoit.plrecipe_group.feature.group.dto.GroupMemberDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GroupMemberService {

   void withdrawalGroup(int group_member_id);


   void invitedToGroup(int groupId, int memberId);

   @Transactional
   void acceptGroupInvitation(int groupId, int memberId);

   List<GroupMemberDTO> selectMembersByGroupId(int groupId);
}
