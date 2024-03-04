package com.sixcandoit.plrecipe_group.feature.group;

import com.sixcandoit.plrecipe_group.aggregate.Group;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GroupServiceTestsByJPA {

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
    public void 새로운_그룹_추가_테스트(){
        Group group = new Group();
        Date date = new Date();
        SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        group.setGroupName("초밥원정대");
        group.setIsGroupPublic("Y");
        group.setGroupCreateDate(dateTest);
        group.setGroupComment("초밥 다 디졌다 드루와");
        group.setGroupStatus("Y");

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.persist(group);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        Assertions.assertTrue((entityManager.contains(group)));
    }

    @Test
    public void 그룹_이름_수정_테스트(){
        Group group = entityManager.find(Group.class,6);

        String groupNameChange = "바뀐 그룹 이름";

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try{
            group.setGroupName(groupNameChange);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        Assertions.assertEquals(groupNameChange,entityManager.find(Group.class,6).getGroupName());
    }

    @Test
    public void 그룹_삭제_테스트(){

        Group groupToRemove = entityManager.find(Group.class, 11);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.remove(groupToRemove);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        Group removeMenu = entityManager.find(Group.class, 11);
        Assertions.assertEquals(null,removeMenu);
    }

}
