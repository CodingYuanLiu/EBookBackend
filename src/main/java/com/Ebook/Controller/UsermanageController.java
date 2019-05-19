package com.Ebook.Controller;


import com.Ebook.Entity.*;
import com.Ebook.Repository.*;

import com.Ebook.Service.UsermanageService;
import com.Ebook.Util.ResponseUtil;
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
    public Response Receive(){
        return ResponseUtil.Success(Service.GetUserinfoService());
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/userblock")
    public Response Block(@RequestParam(required=true,defaultValue="") String userid){
        Service.BlockService(userid);
        return ResponseUtil.Success();
    }
}
