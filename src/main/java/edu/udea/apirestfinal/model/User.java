package edu.udea.apirestfinal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;

//@Entity
//@Table(name="users")
public class User implements Serializable {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String userName;
    private String password;
    private String email;
    private boolean enabled;

    /*
    @ManyToMany
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private HashSet<Rol> roles = new HashSet<>();
    */

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="roles")
    @JsonIgnore
    protected Rol roles;
    public User() {
    }

    public User(String userName, String password, String email, boolean enabled, Rol rol) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.roles = rol;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Rol getRoles() {
        return roles;
    }

    public void setRoles(Rol roles) {
        this.roles = roles;
    }
}
