package com.sixcandoit.plrecipe_group.feature.group.repository;

import com.sixcandoit.plrecipe_group.feature.group.vo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
