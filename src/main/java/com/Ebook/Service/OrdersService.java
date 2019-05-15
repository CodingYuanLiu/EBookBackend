package com.Ebook.Service;

import com.alibaba.fastjson.JSONArray;

public interface OrdersService {
    public JSONArray GetOrdersService(String userid);
    public String SubmitOrderService(String neworder,String re_userid);
}
