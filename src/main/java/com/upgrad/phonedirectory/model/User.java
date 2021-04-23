package com.upgrad.phonedirectory.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "uname" ,unique = true)
    private String uname;

    @Column(name = "password" ,unique = true)
    private String password;

    @Column(name = "email" ,unique = true)
    private String email;

    @Column(name = "phonenum" ,unique = true)
    private String phonenum;

    // RELATIONSHIPS
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Phone> phone = new ArrayList<>();

    // GETTERS AND SETTERS

    public List<Phone> getPosts() {
        return phone;
    }

    public void setPosts(List<Phone> posts) {
        this.phone = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return uname;
    }

    public void setUsername(String uname) {
        this.uname = uname;
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

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
}
