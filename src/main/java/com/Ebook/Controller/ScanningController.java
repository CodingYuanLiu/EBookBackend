package com.Ebook.Controller;

import java.io.*;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Repository.BookinfoRepository;
import java.util.Iterator;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScanningController{
    @Autowired
    private BookinfoRepository repo;
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/scanning")
    public JSONArray Receiving()  throws IOException{
        String jsonstr = "[";
        
        for(Iterator<Bookinfo> it = repo.findAll().iterator(); ((Iterator) it).hasNext();) {

            jsonstr += it.next().toJSONString() + ",";
        }
        jsonstr+="]";
        return JSONArray.fromObject(jsonstr);
    }

}