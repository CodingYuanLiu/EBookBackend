package com.Ebook.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int orderid;
    int userid;
    String time;
    protected Orders(){}
    public void setOrderid(int orderid){ this.orderid = orderid;}
    public void setUserid(int userid) { this.userid = userid;}
    public void setTime(String time) { this.time = time;}
    public int getOrderid() { return this.orderid;}
    public int getUserid() { return this.userid;}
    public String getTime() {return this.time;}
}
