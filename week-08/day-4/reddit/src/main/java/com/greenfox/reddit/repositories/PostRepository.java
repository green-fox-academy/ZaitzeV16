package com.greenfox.reddit.repositories;

import com.greenfox.reddit.models.Post;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>, JpaRepository<Post, Long> {

  public List<Post> findAllByOrderByVotesDesc();

  public Page<Post> findAll(Pageable pageable);

  public List<Post> findByOrderByVotesDesc(Pageable pageable);
}
