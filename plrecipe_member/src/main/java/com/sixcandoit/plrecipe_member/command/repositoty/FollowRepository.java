package com.sixcandoit.plrecipe_member.command.repositoty;

import com.sixcandoit.plrecipe_member.command.aggregate.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
}
