package com.Ebook.Repository;

import com.Ebook.Entity.Bookinfo;
import com.Ebook.Entity.OrderItems;
import com.Ebook.Entity.Orders;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItems, Long> {

    public List<OrderItems> findByOrder(Orders order);

    public List<OrderItems> findAll();
    @Transactional
    public void deleteByBook(Bookinfo book);
}