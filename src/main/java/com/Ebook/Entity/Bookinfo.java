package com.Ebook.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.print.Book;

@Entity
public class Bookinfo {
    private String name;
    private String author;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int bnum;
    private String pic;
    private String price;
    private String router;
    private int remain;
    private int type;
    protected Bookinfo() {}
    public Bookinfo(String name, String author,String pic,String price,String router,int remain,int type){
        this.name = name;
        this.author=author;
        this.pic=pic;
        this.price = price;
        this.router=router;
        this.remain=remain;
        this.type=type;
    }

    public void setname(String name){
        this.name = name;
    };
    public void setauthor(String author){
        this.author = author;
    };
    public void setbum(int bnum){
        this.bnum = bnum;
    };
    public void setpic(String pic){
        this.pic = pic;
    };
    public void setprice(String price) {
        this.price = price;
    };
    public void setrouter(String router){
        this.router = router;
    };
    public void setremain(int remain){
        this.remain = remain;
    };
    public void settype(int type){
        this.type = type;
    }
    public String toJSONString(){
        String json = "{";
        json += "\"name\":" + "\"" + name + "\",";
        json += "\"author\":" + "\"" + author + "\",";
        json += "\"bnum\":" + bnum + ",";
        json += "\"pic\":" + "\"" + pic + "\",";
        json += "\"price\":" + "\"" + price + "\",";
        json += "\"router\":" + "\"" + router + "\",";
        json += "\"remain\":" + remain + ",";
        json += "\"type\":" + type + ",";
        json +="}";
        return json;
    }
}
