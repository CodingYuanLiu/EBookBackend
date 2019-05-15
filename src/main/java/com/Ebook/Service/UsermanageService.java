package com.Ebook.Service;

import com.alibaba.fastjson.JSONArray;

public interface UsermanageService {
    public JSONArray GetUserinfoService();
    public String BlockService(String userid);
}
