package com.nesan.sb.hw.springboothw.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

    @Id
    private String roleId;

    private String Description;

    @ManyToMany(mappedBy = "roles")//If you dont use mapped by create 2 tables user_roles and Roles_user this will jsut create user_roles 
    private List<User> users;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role [Description=" + Description + ", roleId=" + roleId + ", users=" + users + "]";
    }

    

}
