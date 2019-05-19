package com.Ebook.Service;

import com.alibaba.fastjson.JSONObject;

public interface LoginService {
    public JSONObject Login(String username,String password);
}
