package com.sixcandoit.plrecipe_group.feature.group.service;


import com.sixcandoit.plrecipe_group.feature.group.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.feature.group.client.MemberServiceClient;
import com.sixcandoit.plrecipe_group.feature.group.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.feature.group.dto.GroupMemberDTO;
import com.sixcandoit.plrecipe_group.feature.group.dto.MemberDTO;
import com.sixcandoit.plrecipe_group.feature.group.repository.GroupMapper;
import com.sixcandoit.plrecipe_group.feature.group.repository.GroupRepository;

import com.sixcandoit.plrecipe_group.feature.group.repository.MemberRepository;
import com.sixcandoit.plrecipe_group.feature.group.vo.GroupMember;
import com.sixcandoit.plrecipe_group.feature.group.vo.RequestGroup;
import com.sixcandoit.plrecipe_group.feature.group.vo.ResponseMember;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupServiceimpl implements GroupService{

    private final ModelMapper mapper;
    private final GroupRepository groupRepository;
    private GroupMapper groupMapper;

    private final MemberServiceClient memberServiceClient;
    private final MemberRepository memberRepository; // Member 엔터티에 대한 JpaRepository


    @Autowired
    public GroupServiceimpl(ModelMapper mapper,
                            GroupRepository groupRepository,
                            GroupMapper groupMapper,
                            MemberServiceClient memberServiceClient,
                            MemberRepository memberRepository) {
        this.mapper = mapper;
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
        this.memberServiceClient = memberServiceClient;
        this.memberRepository = memberRepository;
    }


    public List<GroupDTO> selectAllGroup() {
        return groupMapper.selectAllGroup();
    }




//    public List<MemberDTO> selectMembersByGroupId(int groupId) {
//        return groupMapper.selectMembersByGroupId(groupId);
//    }

//    @Override
//    public List<GroupDTO> getGroupMembersWithAdditionalInfo(int groupId) {
//        // GroupMapper를 통해 그룹에 속한 멤버의 memberId를 가져옴
//        List<GroupEntity> memberIds = groupMapper.selectMemberIdsByGroupId(groupId);
//
//        // 각 멤버에 대해 추가 정보를 Feign을 통해 가져옴
//        List<ResponseMember> additionalInfoList = memberIds.stream()
//                .map(memberId -> memberServiceClient.getMemberInfo(memberId))
//                .collect(Collectors.toList());
//
//        return additionalInfoList;
//    }


    public List<GroupDTO> selectPublicOrPrivateGroup(int memberId){
        return groupMapper.selectPublicOrPrivateGroup(memberId);

    }

    @Override
    public void registGroup(GroupDTO groupDTO) {
        Date date = new Date();
        SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        GroupEntity groupEntity = mapper.map(groupDTO,GroupEntity.class);
        groupEntity.setGroupCreateDate(dateTest);

        groupRepository.save(groupEntity);
    }

    @Override
    public GroupEntity modifyGroup(int groupId, RequestGroup requestGroup){
       Optional<GroupEntity> optionalGroup = groupRepository.findById(groupId);
       if(!optionalGroup.isPresent()){
           throw new EntityNotFoundException("그룹 없음");
       }
       GroupEntity group = optionalGroup.get();
       group.setGroupName(requestGroup.getGroupName());
       group.setIsGroupPublic(requestGroup.getIsGroupPublic());
       group.setGroupComment(requestGroup.getGroupComment());

       return groupRepository.save(group);
    }

    @Override
    public GroupEntity modifyGroupChangeStatus(int groupId, RequestGroup requestGroup){
        Optional<GroupEntity> optionalGroup = groupRepository.findById(groupId);
        if(!optionalGroup.isPresent()){
            throw new EntityNotFoundException("그룹 없음");
        }

        GroupEntity group = optionalGroup.get();
        group.setGroupStatus(requestGroup.getGroupStatus());

        return groupRepository.save(group);
    }


//
//    @Transactional
//    public void addUserToGroup(int memberId, GroupEntity group) {
//        GroupMember membership = new GroupMember();
//        membership.setMemberId(memberId);
//        membership.setGroup(group);
//
//        entityManager.persist(membership);
//    }
}
