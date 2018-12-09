package gr.uoa.di.m149.service;

import gr.uoa.di.m149.domain.User;
import gr.uoa.di.m149.domain.UserActivity;
import gr.uoa.di.m149.dto.UserResponse;
import gr.uoa.di.m149.exception.CustomException;
import gr.uoa.di.m149.repository.UserRepository;
import gr.uoa.di.m149.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Set;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private AuthenticationManager authenticationManager;

  public UserResponse signin(String username, String password) throws CustomException{
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      String jwt = jwtTokenProvider.createToken(username,  User.roles);
      UserResponse response = new UserResponse(userRepository.findByUsername(username), jwt, jwtTokenProvider.getValidityInMilliseconds());
      return response;
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public UserResponse signup(User user) throws CustomException{
    if (!userRepository.existsByUsername(user.getUsername())) {
      if(!userRepository.existsByEmail(user.getEmail())) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        UserResponse response = new UserResponse(user, jwtTokenProvider.createToken(user.getUsername(), User.roles), jwtTokenProvider.getValidityInMilliseconds());
        return response;
      }
      else {
        throw new CustomException("Email is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
      }
    } else {
      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public User whoami(HttpServletRequest req) {
    return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
  }

  public void addActivity(User user, String query) {
    UserActivity activity = new UserActivity();
    activity.setQuery(query);
    activity.setUser(user);
    activity.setTimestamp(new Timestamp(System.currentTimeMillis()));
    user.addActivity(activity);
    userRepository.save(user);
  }

  public Set<UserActivity> getUserActivities(User user) {
    return user.getUserActivities();
  }

}
