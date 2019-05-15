package com.Ebook.Dao;

import com.Ebook.Entity.Orders;
import com.Ebook.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrdersDao {
    public Orders findByOrderid(int orderid);
    public List<Orders> findByUser(User user);
    public Orders findByTime(String time);
    public void save(Orders order);
}
