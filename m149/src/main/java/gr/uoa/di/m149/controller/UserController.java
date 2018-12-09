package gr.uoa.di.m149.controller;

import gr.uoa.di.m149.domain.User;
import gr.uoa.di.m149.domain.UserActivity;
import gr.uoa.di.m149.dto.UserLogin;
import gr.uoa.di.m149.dto.UserRegister;
import gr.uoa.di.m149.exception.CustomException;
import gr.uoa.di.m149.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  private ModelMapper modelMapper = new ModelMapper();

  @PostMapping(value = "/signin")
  public ResponseEntity<?> login(@RequestBody UserLogin user) {
      try {
        return new ResponseEntity(userService.signin(user.getUsername(), user.getPassword()), HttpStatus.OK);
      } catch (CustomException ex) {
        return new ResponseEntity(ex, ex.getHttpStatus());
      }
  }

  @PostMapping(value = "/signup")
  public ResponseEntity<?> signup(@RequestBody UserRegister user) {
    try {
      return new ResponseEntity(userService.signup(modelMapper.map(user, User.class)), HttpStatus.OK);
    } catch (CustomException ex) {
      return new ResponseEntity(ex, ex.getHttpStatus());
    }
  }

  @GetMapping("/getUserActivities")
  ResponseEntity<?> getUserActivities(HttpServletRequest req) {
    User user = userService.whoami(req);
    Set<UserActivity> activities = userService.getUserActivities(user);
    return new ResponseEntity<>(activities, HttpStatus.OK);

  }

}
