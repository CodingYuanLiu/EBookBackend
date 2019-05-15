package com.Ebook.DaoImpl;

import com.Ebook.Dao.OrdersDao;
import com.Ebook.Entity.Orders;
import com.Ebook.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.Ebook.Repository.OrdersRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersDaoImpl implements OrdersDao {
    @Autowired
    OrdersRepository repo;

    @Override
    public Orders findByOrderid(int orderid){
        return repo.findByOrderid(orderid);
    }

    @Override
    public List<Orders> findByUser(User user){
        return repo.findByUser(user);
    }

    @Override
    public Orders findByTime(String time){
        return repo.findByTime(time);
    }

    @Override
    public void save(Orders order){
        repo.save(order);
    }
}
