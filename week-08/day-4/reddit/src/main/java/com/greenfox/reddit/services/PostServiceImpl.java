package com.greenfox.reddit.services;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.models.User;
import com.greenfox.reddit.repositories.PostRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  // region Fields
  private PostRepository repository;
  // endregion Fields


  // region Constructors
  @Autowired
  public PostServiceImpl(PostRepository repository) {
    this.repository = repository;
  }
  // endregion Constructors


  // region CRUD
  //   region Create
  public Post save(Post post) {
    return this.repository.save(post);
  }

  public Post save(String title, String url, User user) {
    return this.repository.save(new Post(title, url, user));
  }
  //   endregion Create


  //   region Read
  public Post findById(long id) {
    return this.repository.findById(id).orElse(null);
  }

  public List<Post> findAll() {
    List<Post> posts = new ArrayList<>();
    this.repository.findAll().forEach(posts::add);
    return posts;
  }

  @Override
  public List<Post> findAllByOrderByVotesDesc() {
    return this.repository.findAllByOrderByVotesDesc();
  }

  @Override
  public Page<Post> findAll(Pageable pageable) {
    return this.repository.findAll(pageable);
  }

  @Override
  public List<Post> findByOrderByVotesDesc(Pageable pageable) {
    return this.repository.findByOrderByVotesDesc(pageable);
  }

  @Override
  public long count() {
    return this.repository.count();
  }
  //   endregion Read


  //   region Update
  public void downVote(long id) {
    Post post = this.findById(id);

    if (post != null) {
      post.setVotes(post.getVotes() - 1);
    }

    this.save(post);
  }

  public void upVote(long id) {
    Post post = this.findById(id);

    if (post != null) {
      post.setVotes(post.getVotes() + 1);
    }

    this.save(post);
  }
  //   endregion Update
  // endregion CRUD
}
