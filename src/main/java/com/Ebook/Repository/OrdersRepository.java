package com.Ebook.Repository;

import com.Ebook.Entity.OrderItems;
import com.Ebook.Entity.Orders;
import com.Ebook.Entity.ResultOrder;
import com.Ebook.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {
    /*
    @Query(value = "select new com.Ebook.Entity.ResultOrder(" +
            "a.orderid as orderid,a.time as time,c.pic as pic,c.name as name,c.author as author,c.bnum as bnum,b.num as num,c.price as price,a.userid as userid)" +
            " from Orders a, OrderItems b, Bookinfo c where a.orderid=b.orderid and b.bnum=c.bnum and a.userid=:uid")
    List<ResultOrder> select(@Param("uid") int uid);
    @Query(value = "select new com.Ebook.Entity.ResultOrder(" +
            "a.orderid as orderid,a.time as time,c.pic as pic,c.name as name,c.author as author,c.bnum as bnum,b.num as num,c.price as price,a.userid as userid)" +
            " from Orders a, OrderItems b, Bookinfo c where a.orderid=b.orderid and b.bnum=c.bnum")
    List<ResultOrder> selectAllUsers();
    */
    public Orders findByOrderid(int orderid);
    public List<Orders> findByUser(User user);
    public Orders findByTime(String time);

}