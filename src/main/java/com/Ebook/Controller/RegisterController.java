package com.Ebook.Controller;

import java.io.*;
import com.Ebook.Entity.User;
import java.util.Iterator;
import java.util.List;

import com.Ebook.Repository.UserRepository;


import com.Ebook.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService Service;
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/register")
    public User Receiving(@RequestParam(required=true,defaultValue="") String username,
                            @RequestParam(required=true,defaultValue="") String password,
                            @RequestParam(required=true,defaultValue="") String email)  throws Exception{
        return Service.RegisterService(username,password,email);
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/checkdupusername")
    public Boolean Check(@RequestParam(required=true,defaultValue = "")String username){
        return Service.CheckDupUsernameService(username);
    }
}
