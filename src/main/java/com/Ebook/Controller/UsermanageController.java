package com.Ebook.Controller;


import com.Ebook.Entity.*;
import com.Ebook.Repository.*;

import com.Ebook.Service.UsermanageService;
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
    private UsermanageService Service;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/userinfo")
    public JSONArray Receive(){
        return Service.GetUserinfoService();
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/userblock")
    public String Block(@RequestParam(required=true,defaultValue="") String userid){
        return Service.BlockService(userid);
    }
}
