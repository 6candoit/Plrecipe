package com.sixcandoit.plrecipe_post.command.repositroy;

import com.sixcandoit.plrecipe_post.command.aggregate.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagRepository  extends JpaRepository<Hashtag, Integer> {
}
