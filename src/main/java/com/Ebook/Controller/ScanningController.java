package com.Ebook.Controller;

import java.awt.print.Book;
import java.io.*;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Entity.OrderItems;
import com.Ebook.Repository.BookinfoRepository;
import com.Ebook.Repository.OrderItemsRepository;
import java.util.Iterator;
import java.util.List;

import com.Ebook.Service.ScanningService;
import com.alibaba.fastjson.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScanningController{
    @Autowired
    private ScanningService Service;


    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/scanning")
    public JSONArray Receiving()  throws IOException{
        return Service.GetBookService();
    }


    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/modifying")
    public Bookinfo ModifyBook(@RequestParam(required=true,defaultValue = "") String bookstring){
        return Service.ModifyService(bookstring);
    }


    @CrossOrigin(origins="http://localhost:8081")
    @RequestMapping("/delete")
    public int DeleteBook(@RequestParam(required=true,defaultValue="") String bnumstr){
        return Service.DeleteBookService(bnumstr);
    }
}