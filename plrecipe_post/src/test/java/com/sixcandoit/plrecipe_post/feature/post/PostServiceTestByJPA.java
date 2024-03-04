package com.sixcandoit.plrecipe_post.feature.post;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.aggregate.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.text.SimpleDateFormat;
import java.util.Date;


public class PostServiceTestByJPA {

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
    public void 새로운_게시글_추가_테스트() {
        Post post = new Post();
        Date date = new Date();
        SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        post.setPostTitle("게시글 추가 테스트");
        post.setPostContent("게시글 내용");
        post.setPostDate(dateTest);
        post.setMemberId(3);
        post.setCourseId(1);
        post.setIsPostPublic("N");
        post.setMemberCount(MemberCount.MANY);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.persist(post);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        Assertions.assertTrue(entityManager.contains(post));
    }

    @Test
    public void 게시글_이름_수정_테스트() {

        Post post = entityManager.find(Post.class, 10);
        System.out.println("post = " + post);

        String postTitleToChange = "게시글 수정 테스트";

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            post.setPostTitle(postTitleToChange);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        Assertions.assertEquals(postTitleToChange, entityManager.find(Post.class, 10).getPostTitle());

    }

    @Test
    public void 게시글번호로_게시글_조회_테스트() {

        int postId = 10;

        Post foundPost = entityManager.find(Post.class, postId);

        Assertions.assertNotNull(foundPost);
        Assertions.assertEquals(postId, foundPost.getPostId());
        System.out.println("foundPost = " + foundPost);
    }

    @Test
    public void 게시글_삭제_테스트() {

        Post postToRemove = entityManager.find(Post.class, 12);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.remove(postToRemove);
            entityTransaction.commit();

        } catch (Exception e) {
            entityTransaction.rollback();
        }

        // then
        Post removeMenu = entityManager.find(Post.class, 12);
        Assertions.assertEquals(null, removeMenu);
    }
}
