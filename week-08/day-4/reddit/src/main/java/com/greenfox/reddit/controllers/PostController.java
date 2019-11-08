package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.models.User;
import com.greenfox.reddit.services.PostServiceImpl;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

//  public Page<Post> findAll(long pageNumber) {
//    Pageable pageable
//    return this.postService.findAll(pageable);
//  }

  public List<Post> findByOrderByVotesDesc(int pageNumber) {
    long numberOfItems = this.count();
    int pageSize = 10;

    if ((pageNumber + 1) * pageSize > numberOfItems) {
      pageNumber = (int) (numberOfItems % (long) pageSize);
    }

    return this.postService.findByOrderByVotesDesc(PageRequest.of(pageNumber, pageSize));
  }

  public long count() {
    return this.postService.count();
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
