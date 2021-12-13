package com.nesan.sb.hw.springboothw.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
    @Id
    private String userid;

    private String email;

    private String password;

    @ManyToMany(cascade = CascadeType.ALL)//Many to many to many will always create a third table
    private List<Role> roles;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + ", roles=" + roles + ", userid=" + userid + "]";
    }

    

    
    
}
