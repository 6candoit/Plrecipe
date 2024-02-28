package com.sixcandoit.plrecipe.feature.group;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GroupServiceTests {
    @Autowired
    private Group groupService;

    @Test
    void testAllGroupSelect() {

        List<GroupDTO> group = groupService.selectAllGroup();
        group.forEach(System.out::println);

        assertNotNull(group);
    }

    @ParameterizedTest
    @ValueSource(strings={"mfk5gd@daum.net"})
    void selectPublicOrPrivateGroup(String memberEmail){
        List<GroupDTO> groupList = groupService.selectPublicOrPrivateGroup(memberEmail);
        groupList.forEach(System.out::println);

        assertNotNull(groupList);
    }
}
