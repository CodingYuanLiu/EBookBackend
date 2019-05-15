package com.Ebook.DaoImpl;

import com.Ebook.Dao.OrderItemsDao;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Entity.OrderItems;
import com.Ebook.Entity.Orders;
import com.Ebook.Repository.OrderItemsRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemsDaoImpl implements OrderItemsDao {
    @Autowired
    OrderItemsRepository oirepo;

    @Override
    public List<OrderItems> findByOrder(Orders order){
        return oirepo.findByOrder(order);
    }

    @Override
    public List<OrderItems> findAll(){
        return oirepo.findAll();
    }

    @Override
    public List<OrderItems> findByBook(Bookinfo book){
        return oirepo.findByBook(book);
    }

    @Override
    public void  save(OrderItems oi){
        oirepo.save(oi);
    }
}
