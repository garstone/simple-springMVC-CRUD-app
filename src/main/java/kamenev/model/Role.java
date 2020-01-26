package kamenev.model;

import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority {

    @Id
    private String role;
    //private int id;
    //private String login;
    @Transient
    @ManyToMany(mappedBy="roles")
    private Set<User> users;

    public Role() {
    }

    @Override
    public String getAuthority() {
        return role;
    }

    public Role(String role) {
        this.role = role;
    }
/*
    public Role(int id, String login) {
        this.id = id;
        this.login = login;
    }

    @Override
    public String getAuthority() {
        return getLogin();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

 */

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
