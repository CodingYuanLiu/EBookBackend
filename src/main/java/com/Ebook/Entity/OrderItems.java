package com.Ebook.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int itemid;

    int orderid;
    int bnum;
    int num;
    protected OrderItems(){}
    public void setOrderid(int orderid){ this.orderid = orderid;}
    public void setItemid(int itemid) { this.itemid = itemid;}
    public void setBnum(int bnum) { this.bnum = bnum;}
    public void setNum(int num) { this.num = num;}
    public int getOrderid() { return this.orderid;}
    public int getItemid() { return this.itemid;}
    public int getBnum() {return this.bnum;}
    public int getNum() {return this.num;}
}
