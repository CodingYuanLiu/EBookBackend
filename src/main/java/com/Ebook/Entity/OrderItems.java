package com.Ebook.Entity;

import javax.persistence.*;

@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int itemid;

    //@ManyToOne
    //@JoinColumn(name="order_fk")
    int orderid;

    //@ManyToOne
    //@JoinColumn(name="bnum_fk")
    int bnum;
    int num;
    protected OrderItems(){}
    public OrderItems(int orderid,int bnum,int num){
        this.orderid=orderid;
        this.bnum=bnum;
        this.num=num;
    }
    public void setOrderid(int orderid){ this.orderid = orderid;}
    public void setItemid(int itemid) { this.itemid = itemid;}
    public void setBnum(int bnum) { this.bnum = bnum;}
    public void setNum(int num) { this.num = num;}
    public int getOrderid() { return this.orderid;}
    public int getItemid() { return this.itemid;}
    public int getBnum() {return this.bnum;}
    public int getNum() {return this.num;}
}
