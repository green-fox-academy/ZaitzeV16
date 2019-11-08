package com.greenfox.reddit.services;

import com.greenfox.reddit.models.Post;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

  public List<Post> findAllByOrderByVotesDesc();

  public Page<Post> findAll(Pageable pageable);

  public List<Post> findByOrderByVotesDesc(Pageable pageable);

  public long count();
}
