package com.Ebook.Controller;

import java.awt.print.Book;
import java.io.*;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Entity.OrderItems;
import com.Ebook.Entity.Response;
import com.Ebook.Repository.BookinfoRepository;
import com.Ebook.Repository.OrderItemsRepository;
import java.util.Iterator;
import java.util.List;

import com.Ebook.Service.ScanningService;
import com.Ebook.Util.ResponseUtil;
import com.alibaba.fastjson.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScanningController{
    @Autowired
    private ScanningService Service;


    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/scanning")
    public Response Books()  throws IOException{
        return ResponseUtil.Success(Service.GetBookService());
    }


    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/modifying")
    public Response ModifyBook(@RequestParam(required=true,defaultValue = "") String bookstring){
        return ResponseUtil.Success(Service.ModifyService(bookstring));
    }


    @CrossOrigin(origins="http://localhost:8081")
    @RequestMapping("/delete")
    public Response DeleteBook(@RequestParam(required=true,defaultValue="") String bnumstr){
        Service.DeleteBookService(bnumstr);
        return ResponseUtil.Success();
    }
}