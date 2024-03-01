package com.sixcandoit.plrecipe_group.feature.group;

import com.sixcandoit.plrecipe_group.feature.group.dto.GroupDTO;
import com.sixcandoit.plrecipe_group.feature.group.dto.MemberDTO;
import com.sixcandoit.plrecipe_group.feature.group.entity.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GroupServiceTestsByMyBatis {

    @Autowired
    private Group groupService;

    @Test
    void testAllGroupSelect() {

        List<GroupDTO> groupList = groupService.selectAllGroup();
        groupList.forEach(System.out::println);

        assertNotNull(groupList);
    }


    @Test
    void testSelectMembersByGroupId() {
        int groupId = 1;

        List<MemberDTO> members = groupService.selectMembersByGroupId(groupId);

        assertNotNull(members);

        for (MemberDTO member : members) {
            System.out.println(member);
        }

    }

//    @ParameterizedTest
//    @ValueSource(strings = {"mfk5gd@daum.net"})
//    void selectPublicOrPrivateGroup(String memberEmail) {
//        List<GroupDTO> groupList = groupService.selectPublicOrPrivateGroup(memberEmail);
//        groupList.forEach(System.out::println);
//
//        assertNotNull(groupList);
//    }
}