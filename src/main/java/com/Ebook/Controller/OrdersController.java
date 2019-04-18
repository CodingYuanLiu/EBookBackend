package com.Ebook.Controller;

import com.Ebook.Entity.*;
import com.Ebook.Repository.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersRepository orderrepo;
    private OrderItemsRepository orderitemrepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/orders")
    public JSONArray Receiving(@RequestParam(required=true,defaultValue="") String userid){
        int uid = Integer.parseInt(userid);
        /*
        List<Orders> orders = orderrepo.findByUserid(uid);
        List<OrderItems> orderItems = new ArrayList<OrderItems>();
        for(int i =0;i<orders.size();i++){
            List<OrderItems> a_order = orderitemrepo.findByOrderid(orders.get(i).getOrderid());
            orderItems.addAll(a_order);
        }
        return userid;
        */
        List<ResultOrder> result = orderrepo.select(uid);
        return JSONArray.parseArray(JSON.toJSONString(result));
    }
}
