package com.Ebook.ServiceImpl;

import com.Ebook.Dao.*;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Entity.OrderItems;
import com.Ebook.Entity.Orders;
import com.Ebook.Entity.User;
import com.Ebook.Service.OrdersService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private UserDao userrepo;

    @Autowired
    private BookinfoDao bookrepo;

    @Autowired
    private OrderItemsDao orderitemrepo;

    @Autowired
    private OrdersDao orderrepo;

    @Override
    public JSONArray GetOrdersService(String userid){
        int uid = Integer.parseInt(userid);
        List<OrderItems> result = new ArrayList<OrderItems>();
        if(uid==1)//Is admin
        {
            result = orderitemrepo.findAll();
        }
        else{
            User user=userrepo.findByUserid(uid);
            List<Orders> orders=orderrepo.findByUser(user);
            List<OrderItems> orderitems;
            for(Orders order:orders){
                orderitems = orderitemrepo.findByOrder(order);
                result.addAll(orderitems);
            }
        }
        return JSONArray.parseArray(JSON.toJSONString(result));
    }

    @Override
    public String SubmitOrderService(String neworder,String re_userid){
        JSONArray arr=JSON.parseArray(neworder);
        int userid=Integer.parseInt(re_userid);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=df.format(new Date());
        orderrepo.save(new Orders(userrepo.findByUserid(userid),date));
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
            book.setRemain(book.getRemain()-num);
            bookrepo.save(book);
            orderitemrepo.save(new OrderItems(order,book,num));
        }
        if(unseccessful == arr.size()){
            ret = "Fail";
        }
        return ret;
    }
}
