package com.sixcandoit.plrecipe_post.command.repositroy;

import com.sixcandoit.plrecipe_post.command.aggregate.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Integer> {
}
