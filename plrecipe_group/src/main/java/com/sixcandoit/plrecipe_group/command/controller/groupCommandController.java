package com.sixcandoit.plrecipe_group.command.controller;


import com.sixcandoit.plrecipe_group.command.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.command.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.command.service.commandMemberService;
import com.sixcandoit.plrecipe_group.command.service.commandService;
import com.sixcandoit.plrecipe_group.command.vo.RequestGroup;
import com.sixcandoit.plrecipe_group.command.vo.ResponseGroup;
import com.sixcandoit.plrecipe_group.command.vo.ResponseGroupMember;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class groupCommandController {

    private commandService groupService;
    private ModelMapper modelMapper;
    private commandMemberService groupMemberService;

    @Autowired
    public groupCommandController(commandService groupService, ModelMapper modelMapper, commandMemberService groupMemberService) {
        this.groupService = groupService;
        this.modelMapper = modelMapper;
        this.groupMemberService = groupMemberService;
    }

    @PostMapping("/regist")
    private ResponseEntity<ResponseGroup> registGroup(@RequestBody RequestGroup group) {
        GroupDTO groupDTO = modelMapper.map(group, GroupDTO.class);
        groupService.registGroup(groupDTO);
        ResponseGroup responseGroup = modelMapper.map(groupDTO, ResponseGroup.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseGroup);
    }

//    @PostMapping("/modify")
//    private ResponseEntity<ResponseGroup> modifyGroup(@PathVariable int groupId ,@RequestBody RequestGroup group){
//        GroupDTO groupDTO = modelMapper.map(group,GroupDTO.class);
//        groupService.modifyGroup(groupDTO);
//        return
//    }

    @PatchMapping("/modify/{groupId}")
    public ResponseEntity<GroupEntity> modifyGroup(@RequestBody RequestGroup requestGroup, @PathVariable int groupId) {
        return ResponseEntity.ok(groupService.modifyGroup(groupId, requestGroup));
    }

    @PatchMapping("/delete/{groupId}")
    public ResponseEntity<GroupEntity> modifyGroupChangeStatus(@RequestBody RequestGroup requestGroup, @PathVariable int groupId) {
        return ResponseEntity.ok(groupService.modifyGroupChangeStatus(groupId, requestGroup));
    }

    @DeleteMapping("/withdrawal/{groupMemberId}")
    public ResponseEntity<ResponseGroupMember> withdrawalGroup(@PathVariable int groupMemberId) {
        groupMemberService.withdrawalGroup(groupMemberId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/invite/{groupId}/{memberId}")
    public ResponseEntity<String> invitedToGroup(@PathVariable int groupId, @PathVariable int memberId) {
        groupMemberService.invitedToGroup(groupId, memberId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/accept-invitation/{groupId}/{memberId}")
    public ResponseEntity<String> acceptInvitation(@PathVariable int groupId, @PathVariable int memberId) {
        try {
            groupMemberService.acceptGroupInvitation(groupId, memberId);
            return ResponseEntity.ok("Invitation accepted successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
