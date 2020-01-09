package kamenev.model;

import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="t_role")
public class Role implements GrantedAuthority {

    @Id
    private int id;
    private String login;
    @Transient
    @ManyToMany(mappedBy="roles")
    private Set<User> users;

    public Role() {
    }

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
