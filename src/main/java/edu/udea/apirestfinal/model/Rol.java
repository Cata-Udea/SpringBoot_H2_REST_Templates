package edu.udea.apirestfinal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;

//@Entity
//@Table(name="roles")
public class Rol implements Serializable {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  Long id;
    private String name;
    private boolean enabled;
    private HashSet<User> users = new HashSet<>();

    public Rol() {
    }

    public Rol(String name, boolean enabled, HashSet<User> users) {
        this.name = name;
        this.enabled = enabled;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public HashSet<User> getUsers() {
        return users;
    }

    public void setUsers(HashSet<User> users) {
        this.users = users;
    }
}
