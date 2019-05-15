package com.Ebook.Service;

import com.Ebook.Entity.Bookinfo;
import com.alibaba.fastjson.JSONArray;

public interface ScanningService {
    public JSONArray GetBookService();
    public Bookinfo ModifyService(String bookstring);
    public int DeleteBookService(String bnumstr);
}
