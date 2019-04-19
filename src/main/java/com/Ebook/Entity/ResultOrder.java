package com.Ebook.Entity;

public class ResultOrder {
    private int orderid;
    private String time;
    private String pic;
    private String name;
    private String author;
    private int bnum;
    private int num;
    private String price;
    private int userid;
    public ResultOrder(int orderid,String time,String pic,String name,String author,int bum,int num,String price,int userid){
        this.orderid=orderid;
        this.time=time;
        this.pic=pic;
        this.name=name;
        this.author=author;
        this.bnum=bum;
        this.num=num;
        this.price=price;
        this.userid=userid;
    }
    public void setOrderid(int orderid) { this.orderid=orderid;}
    public void setTime(String time) { this.time=time;}
    public void setPic(String pic) { this.pic = pic;}
    public void setName(String name) { this.name = name;}
    public void setAuthor(String author){ this.author=author;}
    public void setBnum(int bnum){ this.bnum=bnum;}
    public void setNum(int num) {this.num = num;}
    public void setPrice(String price){ this.price=price;}
    public void setUserid(int userid){ this.userid=userid;}
    public int getUserid() { return this.userid;}
    public int getOrderid() { return this.orderid;}
    public String getTime() {return this.time;}
    public String getPic() { return this.pic;}
    public String getName() {return this.name;}
    public String getAuthor() { return this.author;}
    public int getBnum() {return this.bnum;}
    public int getNum() { return this.num;}
    public String getPrice() {return this.price;}

}
