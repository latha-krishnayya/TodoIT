package se.lexicon.sneha.model;

import java.io.Serializable;
import java.util.Objects;

public class AppUser{
    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {
        if(username == null){
            throw new RuntimeException("username can't be null");
        }
        else if(password == null){
            throw new RuntimeException("password can't be null");
        }
        else if(role == null){
            throw new RuntimeException("role can't be empty");
        }
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
