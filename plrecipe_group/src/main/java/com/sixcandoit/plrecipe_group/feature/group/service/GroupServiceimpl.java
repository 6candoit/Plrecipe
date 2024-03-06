package com.sixcandoit.plrecipe_group.feature.group.service;


import com.sixcandoit.plrecipe_group.feature.group.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.feature.group.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.feature.group.dto.MemberDTO;
import com.sixcandoit.plrecipe_group.feature.group.repository.GroupMapper;
import com.sixcandoit.plrecipe_group.feature.group.repository.GroupRepository;

import com.sixcandoit.plrecipe_group.feature.group.vo.RequestGroup;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceimpl implements GroupService{

    private final ModelMapper mapper;
    private final GroupRepository groupRepository;
    private GroupMapper groupMapper;
    private Environment env;

    @Autowired
    public GroupServiceimpl( ModelMapper mapper,
                            GroupRepository groupRepository,
                            GroupMapper groupMapper,
                            Environment env) {
        this.mapper = mapper;
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
        this.env = env;
    }


    public List<GroupDTO> selectAllGroup() {
        return groupMapper.selectAllGroup();
    }


    public List<MemberDTO> selectMembersByGroupId(int groupId) {
        return groupMapper.selectMembersByGroupId(groupId);

    }

    public List<GroupDTO> selectPublicOrPrivateGroup(int memberId){
        return groupMapper.selectPublicOrPrivateGroup(memberId);

    }

    @Override
    public void registGroup(GroupDTO groupDTO) {
        Date date = new Date();
        SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

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
