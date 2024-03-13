package com.sixcandoit.plrecipe_group.command.repository;

import com.sixcandoit.plrecipe_group.command.aggregate.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {

}
