package lib.edu.libraryapp.controller.dto.auth;

import lib.edu.libraryapp.commonTypes.UserRole;

public class RegisterResponseDto {

    private String username;
    private UserRole role;
    private String email;
    private String fullName;
    private long userId;


    public RegisterResponseDto(String username, UserRole role, String email,String fullName, long userId) {
        this.username = username;
        this.role = role;
        this.email = email;
        this.fullName = fullName;
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
