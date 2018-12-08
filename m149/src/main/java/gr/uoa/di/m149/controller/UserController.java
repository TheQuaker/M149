package gr.uoa.di.m149.controller;

import gr.uoa.di.m149.domain.User;
import gr.uoa.di.m149.dto.UserLogin;
import gr.uoa.di.m149.dto.UserRegister;
import gr.uoa.di.m149.exception.CustomException;
import gr.uoa.di.m149.service.UserService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
public class UserController {

  @Autowired
  private UserService userService;

  private ModelMapper modelMapper = new ModelMapper();

  @PostMapping(value = "/signin")
  @ApiOperation(value = "${UserController.signin}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 422, message = "Invalid username/password supplied")})
  public ResponseEntity<?> login(@ApiParam("User signin") @RequestBody UserLogin user) {
      try {
        return new ResponseEntity(userService.signin(user.getUsername(), user.getPassword()), HttpStatus.OK);
      } catch (CustomException ex) {
        return new ResponseEntity(ex.getMessage(), ex.getHttpStatus());
      }
  }

  @PostMapping(value = "/signup")
  @ApiOperation(value = "${UserController.signup}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 422, message = "Username is already in use"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public ResponseEntity<?> signup(@ApiParam("User signup") @RequestBody UserRegister user) {
    try {
      return new ResponseEntity(userService.signup(modelMapper.map(user, User.class)), HttpStatus.OK);
    } catch (CustomException ex) {
      return new ResponseEntity(ex.getMessage(), ex.getHttpStatus());
    }
  }



}
