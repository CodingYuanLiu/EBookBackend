package com.Ebook.Controller;


import com.Ebook.Entity.*;
import com.Ebook.Repository.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UsermanageController {
    @Autowired
    private UserRepository repo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/userinfo")
    public JSONArray Receive(){
        List<User> users= repo.findByAuthority("USER");
        List<User> blockedusers=repo.findByAuthority("BLOCKED");
        users.addAll(blockedusers);
        return JSONArray.parseArray(JSON.toJSONString(users));
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/userblock")
    public String Block(@RequestParam(required=true,defaultValue="") String userid){
        User user=repo.findByUserid(Integer.parseInt(userid));
        String res="";
        if(user.getAuthority().equals("BLOCKED")){
            user.setAuthority("USER");
            repo.save(user);
            res="USER";
        }
        else if(user.getAuthority().equals("USER")){
            user.setAuthority("BLOCKED");
            repo.save(user);
            res="BLOCKED";
        }
        return res;
    }
}
