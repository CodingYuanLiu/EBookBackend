package com.Ebook.Controller;
import com.Ebook.Entity.*;
import com.Ebook.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserRepository repo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/login")
    public String Receiving(@RequestParam(required=true,defaultValue="") String username,
                            @RequestParam(required=true,defaultValue="") String password){
        List<User> finduser = repo.findByUsername(username);
        if(finduser.size() == 0){
            return "Unexist";
        }
        else{
            User user= finduser.get(0);
            if(user.checkpassword(username,password)) {
                return "Valid";
            }
            else{
                return "Wrong password";
            }
        }
    }
}
