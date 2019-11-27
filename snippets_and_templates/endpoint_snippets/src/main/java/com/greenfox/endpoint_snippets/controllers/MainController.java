package com.greenfox.endpoint_snippets.controllers;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

  // region Fields
  private SomeServiceImpl someService;
  private AnotherServiceImpl anotherService;
  // endregion Fields


  // region Constructors
  /*
  to autowire a field, it should some kind of spring `Bean`
  for example:  @Service, @Repository, @Entity
   */
  @Autowired
  public MainController(SomeServiceImpl someService, AnotherServiceImpl anotherService) {
    this.someService = someService;
    this.anotherService = anotherService;
  }
  // endregion Constructors

  // region GetMappings

  /**
   * Using `String` as return type, the `String` should be the corresponding HTML file's name.
   * (WITHOUT `.html`!!!)
   */
  @GetMapping(value = "/")
  public String index() {
    return "index";
  }

  /**
   * To use the same endpoint for multiple URLs, put the URLs into curly braces {}
   */
  @GetMapping(value = {"/register", "/register/"})
  public String register() {
    return "register";
  }

  /**
   * Using `ModelAndView` as return type, you need to use it's `setViewName()` and set the HTML
   * file's name, just as using String. (WITHOUT `.html`!!!)
   * <p>
   * With `ModelAndView`, you are able to add objects as well. It is basically the join of the
   * String return value and the `Model` object (as the name suggests).
   */
  @GetMapping(value = {"/assignees", "/assignees/", "/assignees/list"})
  public ModelAndView endpointWithModelAndView(ModelAndView modelAndView) {
    modelAndView.addObject("assignees", this.assigneeService.findAll());
    modelAndView.setViewName("assigneesWithout.html!");
    return modelAndView;
  }

  /**
   * To pass an object to the frontend, you can use `Model` and it's addAttribute() method. The
   * signature is `addAttribute(attributeName, attributeValue)`.
   * <p>
   * In the frontend, you can retrieve the added object using Thymeleaf's `${attributeName}`.
   */
  @GetMapping(value = "/someurl")
  public String usingModel(Model model) {
    model.addAttribute("attributeName", "attributeValue");
    return "table";
  }
  // endregion GetMappings

  // region PostMappings

  /**
   * After importing spring-starter-security dependency and logging in, spring creates a `Principal`
   * object which will contain the currently logged in user.
   * <p>
   * !!!NOTE!!!: to use this, you will need a `SecurityConfiguration` class (inside `security`
   * package). If you need the Principal object in a method, you should add itt to the method
   * signature.
   * <p>
   * To redirect to a specific endpoint (using String return value), you only need to type:
   * `redirect:/endpoint`
   */
  @PostMapping(value = {"/submit", "/submit/"})
  public String submit(Principal principal) {
    User user = userService.findByUsername(principal.getName());
    this.userService.save(user, new ChildOfUser());
    return "redirect:/";
  }

  /**
   * To pass objects to the frontend (or to another endpoint) with redirect, add a
   * `RedirectAttributes` object to the method signature and call it's
   * `addFlashAttribute(attributeName, attributeValue)` with the wanted values (just like
   * Model.addAttribute()).
   * <p>
   * To retrieve the flash attribute in the method (to which you just redirected), add
   * `@ModelAttribute(`flashAttribute`) Object flashAttribute` to the method signature.
   * <p>
   * If you use `addFlashAttribute`, the added object is alive until the redirect chain's end.
   * !!!NOTE!!!: if there is only 1 redirect and stops the chain at the targeted method, you have a
   * one-item-chain. If you have another redirect in the target method and stops after that, you
   * have a two-item-chain.
   */
  @PostMapping(value = {"/register", "/register/"})
  public String register(
      RedirectAttributes ra,
      @RequestParam(name = "username") String username,
      @RequestParam(name = "password") String password) {
    if (this.userService.findByUsername(username) != null) {
      ra.addFlashAttribute("error_msg", "Account already exists!");
      return "redirect:/register";
    }
    User newUser = new User(username, password);
    this.userService.save(newUser);
    return "redirect:/";
  }

  /**
   * You can also use `RedirectView` with `RedirectAttributes` to redirect.
   */
  @PostMapping("/redirectWithRedirectView")
  public RedirectView redirectUsingRedirectView(RedirectAttributes attributes) {
    attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
    attributes.addAttribute("attribute", "redirectWithRedirectView");
    return new RedirectView("redirectedUrl");
  }
  // endregion PostMappings
}
