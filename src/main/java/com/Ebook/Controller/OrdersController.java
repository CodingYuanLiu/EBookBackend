package com.Ebook.Controller;

import com.Ebook.Entity.*;
import com.Ebook.Repository.*;

import com.Ebook.Service.OrdersService;
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
    public JSONArray Receiving(@RequestParam(required=true,defaultValue="1") String userid){
        return Service.GetOrdersService(userid);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/submitorder")
    public String Submit(@RequestParam(required=true,defaultValue = "")String receive,
                         @RequestParam(required = true,defaultValue = "")String re_userid) {
        return Service.SubmitOrderService(receive,re_userid);
    }
}
