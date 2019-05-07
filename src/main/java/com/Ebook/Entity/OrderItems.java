package com.Ebook.Entity;

import javax.persistence.*;
import java.awt.print.Book;

@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int itemid;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="orderid",referencedColumnName = "orderid")
    Orders order;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="bnum",referencedColumnName = "bnum")
    Bookinfo book;

    int num;
    protected OrderItems(){}
    public OrderItems(Orders order,Bookinfo book,int num){
        this.order=order;
        this.book=book;
        this.num=num;
    }
    public void setOrder(Orders order){ this.order = order;}
    public void setItemid(int itemid) { this.itemid = itemid;}
    public void setBook(Bookinfo book) { this.book = book;}
    public void setNum(int num) { this.num = num;}
    public Orders getOrder() { return this.order;}
    public int getItemid() { return this.itemid;}
    public Bookinfo getBook() {return this.book;}
    public int getNum() {return this.num;}
}
