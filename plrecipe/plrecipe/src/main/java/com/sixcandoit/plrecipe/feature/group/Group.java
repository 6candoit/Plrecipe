package com.sixcandoit.plrecipe.feature.group;

import com.sixcandoit.plrecipe.feature.place.PlaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Group {

    private GroupMapper groupMapper;

    @Autowired
    public Group(GroupMapper groupMapper) {this.groupMapper = groupMapper;}

    public List<GroupDTO> selectAllGroup() {
        return groupMapper.selectAllGroup();
    }
}
