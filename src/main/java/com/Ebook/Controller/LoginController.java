package com.Ebook.Controller;
import com.Ebook.Entity.*;
import com.Ebook.Repository.*;

import com.Ebook.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService service;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/login")
    public String Receiving(@RequestParam(required=true,defaultValue="") String username,
                            @RequestParam(required=true,defaultValue="") String password){
        return service.Login(username,password);
    }
}
