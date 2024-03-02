package com.sixcandoit.plrecipe_post.feature.post;

import com.sixcandoit.plrecipe_post.feature.post.entity.Hashtag;
import com.sixcandoit.plrecipe_post.feature.post.entity.PostHashtag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.text.SimpleDateFormat;

public class HashtagServiceTestByJPA {
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
    public void 새로운_해시태그_추가_테스트() {
        Hashtag hashtag = new Hashtag();

        hashtag.setHashtagTitle("해시태그 추가 테스트");

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.persist(hashtag);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        Assertions.assertTrue(entityManager.contains(hashtag));
    }

    @Test
    public void 해시태그번호_조회_테스트() {
        int hashtag = 10;

        Hashtag foundHashtag = entityManager.find(Hashtag.class, hashtag);

        Assertions.assertNotNull(foundHashtag);
        Assertions.assertEquals(hashtag, foundHashtag.getHashtagId());
        System.out.println("foundHashtag = " + foundHashtag);
    }

    @Test
    public void 해시태그_삭제_테스트() {

        Hashtag hashtagToRemove = entityManager.find(Hashtag.class, 13);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.remove(hashtagToRemove);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        Hashtag removeHashtag = entityManager.find(Hashtag.class, 13);
        Assertions.assertEquals(null, removeHashtag);
    }
}
