package com.sixcandoit.plrecipe_group.command.service;

import com.sixcandoit.plrecipe_group.command.aggregate.GroupEntity;
import com.sixcandoit.plrecipe_group.command.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.command.repository.GroupRepository;
import com.sixcandoit.plrecipe_group.command.repository.MemberRepository;
import com.sixcandoit.plrecipe_group.command.vo.RequestGroup;
import com.sixcandoit.plrecipe_group.query.repository.GroupMapper;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class commandServiceImpl implements commandService {

    private final ModelMapper mapper;
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository; // Member 엔터티에 대한 JpaRepository


    @Autowired
    public commandServiceImpl(ModelMapper mapper,
                            GroupRepository groupRepository,
                            MemberRepository memberRepository) {
        this.mapper = mapper;
        this.groupRepository = groupRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void registGroup(GroupDTO groupDTO) {
        Date date = new Date();
        SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        GroupEntity groupEntity = mapper.map(groupDTO, GroupEntity.class);
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

}
