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
            return "Unexist Username";
        }
        else{
            User user= finduser.get(0);
            if(user.checkpassword(username,password)) {
                String info=new String(user.getAuthority());
                info="{\"Authority\":\""+info+"\",";
                info=info+"\"userid\":" + user.getUserid();
                return info+"}";
            }
            else{
                return "Wrong password";
            }
        }
    }
}
