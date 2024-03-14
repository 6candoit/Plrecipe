package com.sixcandoit.plrecipe_group.command.repository;


import com.sixcandoit.plrecipe_group.command.vo.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

}
