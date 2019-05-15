package com.Ebook.Dao;

import com.Ebook.Entity.Bookinfo;
import com.Ebook.Entity.OrderItems;
import com.Ebook.Entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderItemsDao {
    public List<OrderItems> findByOrder(Orders order);

    public List<OrderItems> findAll();

    public List<OrderItems> findByBook(Bookinfo book);

    public void save(OrderItems oi);
}
