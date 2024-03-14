//package com.sixcandoit.plrecipe_member.feature.member;
//
//import com.sixcandoit.plrecipe_member.command.aggregate.Follow;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import org.junit.jupiter.api.*;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class CommandFollowServiceTestsByJPA {
//
//    private static EntityManagerFactory entityManagerFactory;
//    private EntityManager entityManager;
//
//    @BeforeAll
//    public static void initFactory() {
//        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
//    }
//
//    @BeforeEach
//    public void initManager() {
//        entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @AfterAll
//    public static void closeFactory() {
//        entityManagerFactory.close();
//    }
//
//    @AfterEach
//    public void closeManager() {
//        entityManager.close();
//    }
//
//    @Test
//    public void 팔로우_테스트() {
//
//        Follow follow = new Follow();
//
//        follow.setUserFollow(15);
//        follow.setUserFollower(10);
//
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//
//        try {
//            entityManager.persist(follow);
//            entityTransaction.commit();
//        } catch (Exception e) {
//            entityTransaction.rollback();
//        }
//
//        Assertions.assertTrue(entityManager.contains(follow));
//    }
//
//    @Test
//    public void 팔로우_조회() {
//
//        int follow_id = 8;
//
//        Follow foundMember = entityManager.find(Follow.class, follow_id);
//        Assertions.assertNotNull(foundMember);
//        Assertions.assertEquals(follow_id, foundMember.getFollowId());
//
//        System.out.println("foundMember = " + foundMember);
//    }
//
//    @Test
//    public void 팔로우_취소_테스트() {
//
//        Follow followToRemove = entityManager.find(Follow.class, 25);
//
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//
//        try {
//            entityManager.remove(followToRemove);
//            entityTransaction.commit();
//        } catch (Exception e) {
//            entityTransaction.rollback();
//        }
//
//        // then
//        Follow removeFollow = entityManager.find(Follow.class, 25);
//        Assertions.assertEquals(null, removeFollow);
//
//    }
//}
