package com.Ebook.Controller;

import java.io.*;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Repository.BookinfoRepository;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScanningController{
    @Autowired
    private BookinfoRepository repo;
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/scanning")
    public JSONArray Receiving()  throws IOException{
        List<Bookinfo> books = repo.findAll();
        return JSONArray.parseArray(JSON.toJSONString(books));
    }

}