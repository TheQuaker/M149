package gr.uoa.di.m149.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ROLE_USER;

  public String getAuthority() {
    return name();
  }

}
