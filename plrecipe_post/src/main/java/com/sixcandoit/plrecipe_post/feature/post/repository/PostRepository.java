package com.sixcandoit.plrecipe_post.feature.post.repository;

import com.sixcandoit.plrecipe_post.feature.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
