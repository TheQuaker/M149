package gr.uoa.di.m149.controller;

import gr.uoa.di.m149.domain.User;
import gr.uoa.di.m149.exception.CustomException;
import gr.uoa.di.m149.service.UserService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
public class UserController {

  @Autowired
  private UserService userService;


  @PostMapping("/signin")
  @ApiOperation(value = "${UserController.signin}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 422, message = "Invalid username/password supplied")})
  public ResponseEntity<?> login(//
                                 @ApiParam("Username") @RequestParam String username, //
                                 @ApiParam("Password") @RequestParam String password) {
      try {
        return new ResponseEntity<>(userService.signin(username, password), HttpStatus.OK);
      } catch (CustomException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
      }
  }

  @PostMapping("/signup")
  @ApiOperation(value = "${UserController.signup}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 422, message = "Username is already in use"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public ResponseEntity<?> signup( @ApiParam("Username") @RequestParam String username, //
                        @ApiParam("Password") @RequestParam String password,
                        @ApiParam("Email") @RequestParam String email, //
                        @ApiParam("Address") @RequestParam String address)  throws CustomException {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    user.setAddress(address);
    try {
      return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
    } catch (CustomException ex) {
      return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }
  }



}
