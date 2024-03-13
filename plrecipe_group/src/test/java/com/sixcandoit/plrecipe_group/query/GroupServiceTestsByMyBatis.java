package com.sixcandoit.plrecipe_group.query;

import com.sixcandoit.plrecipe_group.query.dto.GroupDTO;

import com.sixcandoit.plrecipe_group.query.service.GroupServiceimpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GroupServiceTestsByMyBatis {

    @Autowired
    private GroupServiceimpl groupServiceimpl;

    @Test
    void testAllGroupSelect() {

        List<GroupDTO> groupList = groupServiceimpl.selectAllGroup();
        groupList.forEach(System.out::println);

        assertNotNull(groupList);
    }


//    @Test
//    void testSelectMembersByGroupId() {
//        int groupId = 1;
//
//        List<MemberDTO> members = groupServiceimpl.selectMembersByGroupId(groupId);
//
//        assertNotNull(members);
//
//        for (MemberDTO member : members) {
//            System.out.println(member);
//        }
//
//    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    void selectPublicOrPrivateGroup(int memberId) {
        List<GroupDTO> groupList = groupServiceimpl.selectPublicOrPrivateGroup(memberId);
        groupList.forEach(System.out::println);

        assertNotNull(groupList);
    }
}