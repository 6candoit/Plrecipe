package com.sixcandoit.plrecipe_member.feature.member.repository;

import com.sixcandoit.plrecipe_member.feature.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
