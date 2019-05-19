package com.Ebook.Controller;
import com.Ebook.Entity.*;
import com.Ebook.Repository.*;

import com.Ebook.Service.LoginService;
import com.Ebook.Util.ResponseUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService service;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/login")
    public Response Receiving(@RequestParam(required=true,defaultValue="") String username,
                            @RequestParam(required=true,defaultValue="") String password){
        JSONObject result = service.Login(username,password);
        if(result.getIntValue("code") == 200) {
            return ResponseUtil.Success(result.getString("data"));
        }
        else{
            return ResponseUtil.Error(result.getIntValue("code"),result.getString("data"));
        }
    }
}
