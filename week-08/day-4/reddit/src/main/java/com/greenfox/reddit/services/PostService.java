package com.greenfox.reddit.services;

import com.greenfox.reddit.models.Post;
import java.util.List;

public interface PostService {

  public List<Post> findAllByOrderByVotesDesc();
}
