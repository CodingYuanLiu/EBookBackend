package com.example.demo;

import java.io.*;
import java.util.ArrayList;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.IOUtils;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class ScanningController{

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/scanning")
    public JSONArray Receiving()  throws IOException{
        InputStream inputStream = new FileInputStream("./src/Info/book.json");
        String text = IOUtils.toString(inputStream,"utf8");
        JSONArray books = JSON.parseArray(text);
        return books;
    }

}