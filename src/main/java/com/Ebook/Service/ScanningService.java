package com.Ebook.Service;

import com.Ebook.Entity.Bookinfo;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

public interface ScanningService {
    public JSONArray GetBookService();
    public Bookinfo ModifyService(String bookstring);
    public int DeleteBookService(String bnumstr);
    public List<String> GetCommentService(int bnum);
}
