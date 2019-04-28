package com.Ebook.Controller;

import java.io.*;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Repository.BookinfoRepository;
import com.Ebook.Repository.OrderItemsRepository;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScanningController{
    @Autowired
    private BookinfoRepository repo;
    @Autowired
    private OrderItemsRepository oirepo;
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/scanning")
    public JSONArray Receiving()  throws IOException{
        List<Bookinfo> books = repo.findAll();
        return JSONArray.parseArray(JSON.toJSONString(books));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/modifying")
    public Bookinfo ModifyBook(@RequestParam(required=true,defaultValue = "") String bookstring){
        Bookinfo book = JSON.parseObject(bookstring,Bookinfo.class);
        //int bnum = book.getInteger("bnum");
        repo.save(book);
        return book;
    }

    @CrossOrigin(origins="http://localhost:8081")
    @RequestMapping("/delete")
    public int DeleteBook(@RequestParam(required=true,defaultValue="") String bnumstr){
        int bnum = Integer.parseInt(bnumstr);
        repo.deleteByBnum(bnum);
        oirepo.deleteByBnum(bnum);
        return bnum;
    }
}