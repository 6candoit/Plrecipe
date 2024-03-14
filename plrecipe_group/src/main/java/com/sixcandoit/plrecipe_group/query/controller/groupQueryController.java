package com.sixcandoit.plrecipe_group.query.controller;

import com.sixcandoit.plrecipe_group.query.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.query.service.GroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class groupQueryController {

    private GroupService groupService;
    private ModelMapper modelMapper;

    @Autowired
    public groupQueryController(GroupService groupService, ModelMapper modelMapper) {
        this.groupService = groupService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/groups")
    public List<GroupDTO> selectAllGroup() {
        return groupService.selectAllGroup();
    }

    //    @GetMapping("/groups/member/{groupId}")
//    public List<MemberDTO> selectMembersByGroupId(@PathVariable int groupId) {
//        return groupService.selectMembersByGroupId(groupId);
//    }

    @GetMapping("/groups/public/{memberId}")
    public List<GroupDTO> selectPublicOrPrivateGroup(@PathVariable int memberId) {
        return groupService.selectPublicOrPrivateGroup(memberId);
    }
}
