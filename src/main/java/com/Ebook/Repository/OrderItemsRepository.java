package com.Ebook.Repository;

import com.Ebook.Entity.OrderItems;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItems, Long> {
}