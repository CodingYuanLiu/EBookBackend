package com.Ebook.Controller;

import java.io.*;
import com.Ebook.Entity.User;
import java.util.Iterator;
import java.util.List;

import com.Ebook.Repository.UserRepository;
import net.sf.json.JSONArray;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    private UserRepository repo;
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/register")
    public User Receiving(@RequestParam(required=true,defaultValue="") String username,
                            @RequestParam(required=true,defaultValue="") String password,
                            @RequestParam(required=true,defaultValue="") String email)  throws Exception{
        User newuser = repo.save(new User(username,password,email,"USER"));
        return newuser;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/checkdupusername")
    public Boolean Check(@RequestParam(required=true,defaultValue = "")String username){
        List<User> finduser = repo.findByUsername(username);
        if(finduser.size()>0)
            return true;
        else
            return false;
    }
}
