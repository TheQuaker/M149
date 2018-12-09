package gr.uoa.di.m149.dto;

import gr.uoa.di.m149.domain.User;

public class UserResponse {

    private String username;
    private String email;
    private String address;
    private String jwt;
    private long mseconds;

    public  UserResponse(User user, String jwt, long mseconds) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.jwt = jwt;
        this.mseconds = mseconds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public long getMseconds() {
        return mseconds;
    }

    public void setMseconds(long mseconds) {
        this.mseconds = mseconds;
    }
}
