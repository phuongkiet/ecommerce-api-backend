package com.tutorial.ecommerceapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column
    private String roleName;

    @JsonIgnore
    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private Set<LocalUser> users;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<LocalUser> getUsers() {
        return users;
    }

    public void setUsers(Set<LocalUser> users) {
        this.users = users;
    }
}
