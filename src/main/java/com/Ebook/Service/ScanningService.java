package com.Ebook.Service;

import com.Ebook.Entity.Bookinfo;
import com.Ebook.Entity.Comment;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

public interface ScanningService {
    public JSONArray GetBookService();
    public Bookinfo ModifyService(String bookstring);
    public int DeleteBookService(String bnumstr);
    public List<Comment> GetCommentService(int bnum);
}
