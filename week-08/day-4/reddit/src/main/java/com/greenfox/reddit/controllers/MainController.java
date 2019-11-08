package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.models.User;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

  // region Fields
  private PostController postController;
  private UserController userController;
  // endregion Fields


  // region Constructors
  @Autowired
  public MainController(PostController postController, UserController userController) {
    this.postController = postController;
    this.userController = userController;
  }
  // endregion Constructors


  // region Spring
  //   region GetMappings
  @GetMapping(value = "/")
  public String index(Model model) {
    int pageNumber = 0;
    model.addAttribute("page_number", pageNumber);
    model.addAttribute("posts", this.postController.findByOrderByVotesDesc(pageNumber));
    return "index";
  }

  @GetMapping(value = "/{page_number}")
  public String index(Model model, @PathVariable(name = "page_number") int pageNumber) {
    pageNumber = (pageNumber == 0) ? 1 : pageNumber;
    model.addAttribute("page_number", pageNumber + 1);
    model.addAttribute("posts", this.postController.findByOrderByVotesDesc(pageNumber));
    return "index";
  }

  @GetMapping(value = {"/downvote/{id}", "/downvote/{id}/"})
  public String downVote(Model model, @PathVariable(name = "id") long id) {
    this.postController.downVote(id);
    model.addAttribute("posts", this.postController.findAllByOrderByVotesDesc());
    return "redirect:/";
  }

  @GetMapping(value = {"/upvote/{id}", "/upvote/{id}/"})
  public String upVote(Model model, @PathVariable(name = "id") long id) {
    this.postController.upVote(id);
    model.addAttribute("posts", this.postController.findAllByOrderByVotesDesc());
    return "redirect:/";
  }

  @GetMapping(value = {"/submit", "/submit/"})
  public String submit() {
    return "submit";
  }

  @GetMapping(value = {"/register", "/register/"})
  public String register() {
    return "register";
  }
  //   endregion GetMappings


  //   region PostMappings
  @PostMapping(value = {"/submit", "/submit/"})
  public String submit(
      Model model,
      Principal principal,
      @RequestParam(name = "title") String title,
      @RequestParam(name = "url") String url) {
    User user = userController.findByUsername(principal.getName());
    this.userController.save(user, new Post(title, url));
    model.addAttribute("posts", this.postController.findAllByOrderByVotesDesc());
    return "redirect:/";
  }

  @PostMapping(value = {"/register", "/register/"})
  public String register(
      Model model,
      RedirectAttributes ra,
      @RequestParam(name = "username") String username,
      @RequestParam(name = "password") String password) {
    if (this.userController.findByUsername(username) != null) {
      ra.addFlashAttribute("error_msg", "Account already exists!");
//      model.addAttribute("error_msg", "Account already exists!");
      System.out.println("faszom");
      return "redirect:/register";
    }
    User newUser = new User(username);
    newUser.setPassword(password);
    this.userController.save(newUser);
    return "redirect:/";
  }
  //   endregion PostMappings
  // endregion Spring
}
