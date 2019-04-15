package com.Ebook.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int userid;

    String username;
    String password;
    String email;
    String authority;
    protected User() {}
    public User(String username,String password,String email,String authority){
        this.username = username;
        this.password = password;
        this.email = email;
        this.authority = authority;
    }
    public boolean checkpassword(String username,String password){
        if(this.username.equals(username) && this.password.equals(password)){
            return true;
        }
        else
            return false;
    }
}
