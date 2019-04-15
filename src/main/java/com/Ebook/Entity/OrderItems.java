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
    
}
