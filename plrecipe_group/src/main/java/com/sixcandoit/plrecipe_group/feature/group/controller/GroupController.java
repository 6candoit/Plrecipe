package com.sixcandoit.plrecipe_group.feature.group.controller;

import com.sixcandoit.plrecipe_group.feature.group.service.GroupServiceimpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
@Slf4j
public class GroupController {

    private Environment env;
    private final GroupServiceimpl groupServiceimpl;

    @Autowired
    public GroupController(Environment env, GroupServiceimpl groupServiceimpl) {
        this.env = env;
        this.groupServiceimpl = groupServiceimpl;
    }
}
