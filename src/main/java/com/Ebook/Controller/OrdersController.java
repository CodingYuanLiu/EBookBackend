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
public class OrdersController {
    @Autowired
    private OrdersRepository orderrepo;
    @Autowired
    private OrderItemsRepository orderitemrepo;
    @Autowired
    private BookinfoRepository bookrepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/orders")
    public JSONArray Receiving(@RequestParam(required=true,defaultValue="1") String userid){
        int uid = Integer.parseInt(userid);
        List<ResultOrder> result;
        if(uid==1)//Is admin
        {
            result = orderrepo.selectAll();
        }
        else
            result = orderrepo.select(uid);
        return JSONArray.parseArray(JSON.toJSONString(result));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/submitorder")
    public String Submit(@RequestParam(required=true,defaultValue = "")String receive,
                         @RequestParam(required = true,defaultValue = "")String re_userid) {
        JSONArray arr=JSON.parseArray(receive);
        int userid=Integer.parseInt(re_userid);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=df.format(new Date());
        orderrepo.save(new Orders(userid,date));
        Orders order = orderrepo.findByTime(date);

        String ret="Valid";
        int unseccessful=0;


        JSONObject item=new JSONObject();
        int bnum=0;int num=0;
        for(int i=0;i<arr.size();i++){
            item=arr.getJSONObject(i);
            bnum = item.getInteger("bnum");
            num = item.getInteger("num");
            Bookinfo book = bookrepo.findByBnum(bnum);
            if(book.getRemain()-num <0){
                ret="Not enough remaining";
                unseccessful+=1;
                continue;
            }
            book.setremain(book.getRemain()-num);
            bookrepo.save(book);
            orderitemrepo.save(new OrderItems(order.getOrderid(),bnum,num));
        }
        if(unseccessful == arr.size()){
            ret = "Fail";
        }

        return ret;
    }
}
