package com.Ebook.Util;

import com.Ebook.Entity.Response;

public class ResponseUtil {
    public static Response Success(Object object){
        Response res = new Response();
        res.setCode(200);
        res.setMsg("Request Sucess.");
        res.setData(object);
        return res;
    }

    public static Response Success(){
        return Success(null);
    }

    public static Response Error(int code,String ErrorMsg){
        Response res = new Response();
        res.setCode(code);
        res.setMsg(ErrorMsg);
        return res;
    }
}
