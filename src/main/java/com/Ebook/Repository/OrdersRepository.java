package com.Ebook.Repository;

import com.Ebook.Entity.Orders;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {
}