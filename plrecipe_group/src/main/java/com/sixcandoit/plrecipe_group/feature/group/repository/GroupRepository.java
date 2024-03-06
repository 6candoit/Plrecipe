package com.sixcandoit.plrecipe_group.feature.group.repository;

import com.sixcandoit.plrecipe_group.feature.group.aggregate.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {

}
