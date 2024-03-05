package com.sixcandoit.plrecipe_member.feature.member;

import com.sixcandoit.plrecipe_member.feature.member.entity.Member;
import com.sixcandoit.plrecipe_member.feature.member.entity.MemberGrade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class MemberServiceTestsByJPA {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    public void 신규_회원_추가_테스트() {

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = new Member();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        member.setMemberEmail("leeruby@naver.com");
        member.setPassword("pass02");
        member.setMemberName("이루비");
        member.setMemberNickname("루비곤쥬");
        member.setMemberNumber("010-8462-1485");
        member.setJoinDate(dateTest);
        member.setMemberGrade(MemberGrade.ROLL_MEMBER);
        member.setMemberStatus("Y");

        try {
            entityManager.persist(member);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(entityManager.contains(member));
    }

    @Test
    public void 회원_닉네임_수정_테스트() {

        Member member = entityManager.find(Member.class, 33);
        System.out.println("member = " + member);

        String changeNicknameTo = "루동이언니";

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            member.setMemberNickname(changeNicknameTo);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        Assertions.assertEquals(changeNicknameTo, entityManager.find(Member.class, 33).getMemberNickname());
    }

    @Test
    public void 회원id로_회원_조회_테스트() {

        int memberId = 33;

        Member foundMember = entityManager.find(Member.class, memberId);
        Assertions.assertNotNull(foundMember);
        Assertions.assertEquals(memberId, foundMember.getMemberId());
        System.out.println("foundMember = " + foundMember);
    }

//    @Test
//    public void 이름으로_회원_조회_테스트() {
//
//        String memberName = "조수빈";
//
//        Member foundMember = entityManager.find(Member.class, memberName);
//        Assertions.assertNotNull(foundMember);
//        Assertions.assertEquals(memberName, foundMember.getMemberEmail());
//        System.out.println("foundMember = " + foundMember);
//    }

    @Test
    public void 회원_탈퇴_테스트() {

        Member member = entityManager.find(Member.class, 33);

        String withdrawalDate = "2024.03.05";
        String memberStatus = "N";

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            member.setWithdrawalDate(withdrawalDate);
            member.setMemberStatus(memberStatus);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        Assertions.assertEquals(withdrawalDate, entityManager.find(Member.class, 33).getWithdrawalDate());
//        Assertions.assertEquals(withdrawalDate, entityManager.find(Member.class, 7).getMemberStatus());
    }
}
