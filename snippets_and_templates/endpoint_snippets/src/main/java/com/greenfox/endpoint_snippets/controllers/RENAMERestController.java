package com.greenfox.endpoint_snippets.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RENAMERestController {


  // region Fields
  private UserServiceImpl userService;
  private ChildOfUserServiceImpl childOfUserService;
  // endregion Fields


  // region Constructors
  /*
  to autowire a field, it should some kind of spring `Bean`
  for example:  @Service, @Repository, @Entity
   */
  @Autowired
  public RENAMERestController(
      UserServiceImpl userService,
      ChildOfUserServiceImpl childOfUserService) {
    this.userService = userService;
    this.childOfUserService = childOfUserService;
  }
  // endregion Constructors

  // region GetMappings

  /**
   * To return JSON, you only need to set the return type to `ResponseEntity` and return a
   * ResponseEntity.status(someHTTPstatus).body(nullOrObject).
   * <p>
   * !!!NOTE!!! ResponseEntity<ContainedObjectType> - the `<ContainedObjectType>` part is optional.
   */
  @GetMapping(value = "/log")
  public ResponseEntity<ResponseDTO> log(
      @RequestParam(name = "count", required = false) Integer count,
      @RequestParam(name = "page", required = false) Integer page,
      @RequestParam(name = "q", required = false) String q
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDTO("properDataAccordingToYourDTO"));
  }
  // endregion GetMappings

  // region PostMappings

  /**
   * If you want to use the JSON contained in the request's body, add `@RequestBody
   * SomeRequestDTOOrEntity input` in the signature.
   * <p>
   * In order to retrieve the endpoint's URL inside the method of the endpoint (without hardcoding
   * it) add `HttpServletRequest request` to the signature. Using it's `getRequestURI()` method, you
   * can retrieve the current endpoint's URL.
   */
  @PostMapping(value = "/arrays")
  public ResponseEntity<ResultDTO> arrays(
      @RequestBody(required = false) SomeRequestDTOOrEntity input,
      HttpServletRequest request
  ) {
    this.logEntryService.save(request.getRequestURI(), input.toString());
    return this.apiService.arrays(input);
  }
  // endregion PostMappings

}
