package com.sixcandoit.plrecipe_member.feature.member.repository;

import com.sixcandoit.plrecipe_member.feature.member.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
}
