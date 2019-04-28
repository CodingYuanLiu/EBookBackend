package com.Ebook.Entity;

import javax.persistence.*;

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
    public Bookinfo(String name, String author,int bnum,String pic,String price,String router,int remain,int type){
        this.name = name;
        this.author=author;
        this.bnum=bnum;
        this.pic=pic;
        this.price = price;
        this.router=router;
        this.remain=remain;
        this.type=type;
    }

    public void setName(String name){
        this.name = name;
    };
    public String getName(){ return this.name;}
    public String getAuthor(){ return this.author;}
    public String getPic(){ return this.pic;}
    public String getPrice(){ return this.price;}
    public String getRouter(){ return this.router;}
    public int getRemain(){ return this.remain; }
    public int getType(){ return this.type; }
    public int getBnum(){return this.bnum;}


    public void setAuthor(String author){
        this.author = author;
    };
    public void setBnum(int bnum){
        this.bnum = bnum;
    };
    public void setPic(String pic){
        this.pic = pic;
    };
    public void setPrice(String price) {
        this.price = price;
    };
    public void setRouter(String router){
        this.router = router;
    };
    public void setRemain(int remain){
        this.remain = remain;
    };
    public void setType(int type){
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
