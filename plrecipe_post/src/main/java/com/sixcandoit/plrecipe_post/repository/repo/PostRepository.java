package com.sixcandoit.plrecipe_post.repository.repo;

import com.sixcandoit.plrecipe_post.aggregate.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByMemberId(Integer integer);
}
