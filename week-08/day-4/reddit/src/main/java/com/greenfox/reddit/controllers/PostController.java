package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.models.User;
import com.greenfox.reddit.services.PostServiceImpl;
import java.awt.print.Pageable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
public class PostController {

  // region Fields
  private PostServiceImpl postService;
  // endregion Fields


  // region Constructors
  @Autowired
  public PostController(PostServiceImpl postService) {
    this.postService = postService;
  }
  // endregion Constructors


  // region CRUD
  //   region Create
  public Post save(Post post) {
    return this.postService.save(post);
  }

  public Post save(String title, String url, User user) {
    return this.postService.save(new Post(title, url, user));
  }
  //   endregion Create


  //   region Read
  public Post findById(long id) {
    return this.postService.findById(id);
  }

  public List<Post> findAll() {
    return this.postService.findAll();
  }

  public List<Post> findAllByOrderByVotesDesc() {
    return this.postService.findAllByOrderByVotesDesc();
  }
  //   endregion Read


  //   region Update
  public void downVote(long id) {
    this.postService.downVote(id);
  }

  public void upVote(long id) {
    this.postService.upVote(id);
  }
  //   endregion Update
  // endregion CRUD
}
