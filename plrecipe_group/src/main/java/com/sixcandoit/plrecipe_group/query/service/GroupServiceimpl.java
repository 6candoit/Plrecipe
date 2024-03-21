package com.sixcandoit.plrecipe_group.query.service;

import com.sixcandoit.plrecipe_group.query.client.MemberServiceClient;
import com.sixcandoit.plrecipe_group.query.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.query.dto.GroupMemberDTO;
import com.sixcandoit.plrecipe_group.query.repository.GroupMapper;
import com.sixcandoit.plrecipe_group.query.vo.GroupMember;
import com.sixcandoit.plrecipe_group.query.vo.ResponseMember;
import org.modelmapper.ModelMapper;

import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class GroupServiceimpl implements GroupService {

    private final ModelMapper mapper;
    private GroupMapper groupMapper;

    private final MemberServiceClient memberServiceClient;

    @Autowired
    public GroupServiceimpl(ModelMapper mapper, GroupMapper groupMapper, MemberServiceClient memberServiceClient) {
        this.mapper = mapper;
        this.groupMapper = groupMapper;
        this.memberServiceClient = memberServiceClient;
    }

    @Override
    public List<GroupDTO> selectAllGroup() {
        return groupMapper.selectAllGroup();
    }

    @Override
    public List<GroupMember> selectMembersByGroupId(int groupId) {
        // 그룹 멤버 목록을 데이터베이스로부터 가져옵니다.
        List<GroupMember> memberList = groupMapper.selectMembersByGroupId(groupId);
        return memberList;
    }

    @Override
    public List<GroupMemberDTO> getGroupMemberDTOList(List<GroupMember> groupMembers) {
        // GroupMemberDTO 목록을 생성합니다.
        return groupMembers.stream()
                .map(groupMember -> {
                    // 각 그룹 멤버를 GroupMemberDTO로 매핑합니다.
                    GroupMemberDTO groupMemberDTO = mapper.map(groupMember, GroupMemberDTO.class);

                    // 해당 그룹 멤버의 회원 정보를 가져와 설정합니다.
                    ResponseMember rm = memberServiceClient.getMemberInfo(groupMember.getMemberId());
                    groupMemberDTO.setMembers(List.of(rm)); // List로 감싸서 설정

                    return groupMemberDTO;
                })
                .collect(Collectors.toList());
    }



    @Override
    public List<GroupDTO> selectPublicOrPrivateGroup(int memberId){
        return groupMapper.selectPublicOrPrivateGroup(memberId);
    }
}


