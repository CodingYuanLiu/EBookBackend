package com.Ebook.Controller;

import com.Ebook.Entity.*;
import com.Ebook.Repository.*;

import com.Ebook.Service.OrdersService;
import com.Ebook.Util.ResponseUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class OrdersController {
    /*
    @Autowired
    private OrdersRepository orderrepo;
    @Autowired
    private OrderItemsRepository orderitemrepo;
    @Autowired
    private BookinfoRepository bookrepo;
    @Autowired
    private UserRepository userrepo;
    */
    @Autowired
    private OrdersService Service;
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/orders")
    public Response Receiving(@RequestParam(required=true,defaultValue="1") String userid){

        return ResponseUtil.Success((Service.GetOrdersService(userid)));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/submitorder")
    public Response Submit(@RequestParam(required=true,defaultValue = "")String receive,
                         @RequestParam(required = true,defaultValue = "")String re_userid) {
        JSONObject result = Service.SubmitOrderService(receive,re_userid);
        if(result.getIntValue("code") == 200)
            return ResponseUtil.Success(result.getString("result"));
        else
            return ResponseUtil.Error(result.getIntValue("code"),result.getString("result"));

    }
}
