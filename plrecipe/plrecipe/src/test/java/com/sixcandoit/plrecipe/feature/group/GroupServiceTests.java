package com.sixcandoit.plrecipe.feature.group;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
}
