package com.Ebook.Repository;

import com.Ebook.Entity.OrderItems;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItems, Long> {
    public List<OrderItems> findByOrderid(int orderid);
}