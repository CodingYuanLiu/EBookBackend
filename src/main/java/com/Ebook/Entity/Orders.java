package com.Ebook.Entity;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int orderid;

    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name="userid",referencedColumnName = "userid")
    User user;
    String time;
    protected Orders(){}
    public Orders(User user,String time){
        this.user=user;
        this.time=time;
    }

    public void setOrderid(int orderid){ this.orderid = orderid;}
    public void setUser(User user) { this.user = user;}
    public void setTime(String time) { this.time = time;}
    public int getOrderid() { return this.orderid;}
    public User getUser() { return this.user;}
    public String getTime() {return this.time;}
}
