package com.Ebook.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface OrdersService {
    public JSONArray GetOrdersService(String userid);
    public JSONObject SubmitOrderService(String neworder, String re_userid);
}
